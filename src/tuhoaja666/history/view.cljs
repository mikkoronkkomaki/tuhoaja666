(ns tuhoaja666.history.view
  (:require [reitit.frontend.easy :as rfe]))

(defn history-page []
  [:div
   [:h2 "Tänne taas historiaa"]
   [:ul
    [:li [:a {:href "http://google.com"} "external link"]]
    [:li [:a {:href (rfe/href ::foobar)} "Missing route"]]
    [:li [:a {:href (rfe/href ::item)} "Missing route params"]]]

   [:div
    {:content-editable true
     :suppressContentEditableWarning true}
    [:p "Link inside contentEditable element is ignored."]
    [:a {:href (rfe/href ::calculator)} "Link"]]])
