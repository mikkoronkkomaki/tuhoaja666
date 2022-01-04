(ns tuhoaja666.core
  (:require
    [reagent.dom :as rdom]
    [re-frame.core :as re-frame]
    [tuhoaja666.events :as events]
    [tuhoaja666.views :as views]
    [tuhoaja666.config :as config]
    [stylefy.core :as stylefy]
    [stylefy.reagent :as stylefy-reagent]
    [reitit.frontend.easy :as rfe]
    [reitit.coercion.spec :as rss]
    [reitit.frontend :as rf]
    [reagent.core :as r]
    [velho-ds.tokens.color :as color]
    [velho-ds.tokens.spacing :as spacing]
    [velho-ds.tokens.font :as font]
    [velho-ds.tokens.font-size :as font-size]
    [tuhoaja666.calculator.view :as calculator-view]
    [tuhoaja666.history.view :as history-view]))

(defonce match (r/atom nil))

(defn current-page []
  [:div
   [:a (stylefy/use-style {:align-self "center"
                           :text-decoration "none"
                           :color color/color-pinky-dark
                           :padding (str "0 " spacing/space-small-rem)} {:href (rfe/href ::calculator)})
    [:span (stylefy/use-style {:font-family font/font-family-heading
                               :font-size font-size/font-size-small
                               :align-self "center"
                               :text-decoration "none"
                               :color color/color-pinky-dark
                               :padding (str "0 " spacing/space-small-rem)})
     "Laskuri"]
    [:a (stylefy/use-style {:align-self "center"
                            :text-decoration "none"
                            :color color/color-pinky-dark
                            :padding (str "0 " spacing/space-small-rem)} {:href (rfe/href ::history)})
     [:span (stylefy/use-style {:font-family font/font-family-heading
                                :font-size font-size/font-size-small
                                :align-self "center"
                                :text-decoration "none"
                                :color color/color-pinky-dark
                                :padding (str "0 " spacing/space-small-rem)})
      "Historia"]]]
   (when @match
     (let [view (:view (:data @match))]
       [view @match]))])

(def routes
  [["/"
    {:name ::calculator
     :view calculator-view/calculator-page}]

   ["/history"
    {:name ::history
     :view history-view/history-page}]])

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (rfe/start!
    (rf/router routes {:data {:coercion rss/coercion}})
    (fn [m] (reset! match m))
    ;; set to false to enable HistoryAPI
    {:use-fragment true})
  (let [root-el (.getElementById js/document "app")]
    (stylefy/init {:dom (stylefy-reagent/init)})
    (rdom/unmount-component-at-node root-el)
    (rdom/render [current-page] root-el)))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))