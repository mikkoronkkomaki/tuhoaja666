(ns tuhoaja666.history.view
  (:require [re-frame.core :as re-frame]
            [stylefy.core :as stylefy]
            [tuhoaja666.history.model :as model]
            [tuhoaja666.history.styles :as styles]
            [tuhoaja666.history.controller :as controller]
            [velho-ds.atoms.area :as areas]))

(defn history-page []
  (let [clauses (re-frame/subscribe [model/formatted-clauses])]
    [:div (stylefy/use-style styles/main-container)
     (if (seq @clauses)
       (into [:div (stylefy/use-style styles/history-grid)]
             (mapv (fn [clause]
                     [areas/shadow-area {:styles styles/clause}
                      [:span clause]])
                   @clauses))
       [:div (stylefy/use-style styles/history-grid)
        [areas/shadow-area {:styles styles/clause}
         [:span "Empty"]]])]))
