(ns tuhoaja666.app.view
  (:require [reitit.frontend.easy :as rfe]
            [stylefy.core :as stylefy]
            [tuhoaja666.app.styles :as styles]
            [tuhoaja666.routes :as routes]))

(defn app [selected-view]
  [:div (stylefy/use-style styles/main-container)
   [:a (stylefy/use-style styles/navigation-link {:href (rfe/href ::routes/calculator)})
    [:span (stylefy/use-style styles/navigation-label)
     "Laskuri"]]
   [:a (stylefy/use-style styles/navigation-link {:href (rfe/href ::routes/history)})
    [:span (stylefy/use-style styles/navigation-label)
     "Historia"]]
   (when @selected-view
     (let [view (:view (:data @selected-view))]
       [view @selected-view]))])
