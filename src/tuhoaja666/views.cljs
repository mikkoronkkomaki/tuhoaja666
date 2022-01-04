(ns tuhoaja666.views
  (:require
    [re-frame.core :as re-frame]
    [tuhoaja666.subs :as subs]
    [velho-ds.atoms.button :as button]
    [stylefy.core :as stylefy]
    [velho-ds.tokens.color :as color]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div (stylefy/use-style {:background-color color/color-neutral-1})
     [:h1 "ADSF"]
     [button/primary-small {:content "HEVONEN"
                            :icon "add"
                            :on-click-fn #(js/alert "KETTU")}]]))
