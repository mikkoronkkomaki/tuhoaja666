(ns tuhoaja666.core
  (:require
    [reagent.core :as r]
    [reagent.dom :as rdom]
    [re-frame.core :as re-frame]
    [reitit.coercion.spec :as rss]
    [reitit.frontend :as rf]
    [reitit.frontend.easy :as rfe]
    [stylefy.core :as stylefy]
    [stylefy.reagent :as stylefy-reagent]
    [tuhoaja666.app.view :as app-view]
    [tuhoaja666.calculator.model :as calculator-model]
    [tuhoaja666.history.model :as history-model]
    [tuhoaja666.routes :as routes]))

(defonce selected-view (r/atom nil))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (rfe/start!
    (rf/router routes/routes {:data {:coercion rss/coercion}})
    (fn [m] (reset! selected-view m))
    {:use-fragment true})
  (let [root-el (.getElementById js/document "app")]
    (stylefy/init {:dom (stylefy-reagent/init)})
    (rdom/unmount-component-at-node root-el)
    (rdom/render [app-view/app selected-view] root-el)))

(defn init []
  (re-frame/dispatch-sync [calculator-model/reset])
  (re-frame/dispatch-sync [history-model/reset])
  (mount-root))