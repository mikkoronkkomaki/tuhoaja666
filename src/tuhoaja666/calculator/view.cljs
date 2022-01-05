(ns tuhoaja666.calculator.view
  (:require [stylefy.core :as stylefy]
            [tuhoaja666.calculator.styles :as styles]
            [velho-ds.atoms.button :as button]
            [velho-ds.atoms.area :as areas]))

(defn number-button [number]
  [:div (stylefy/use-style styles/button)
   [button/primary-small {:content (str number)
                          :on-click-fn #()}]])

(defn function-button [name]
  [:div (stylefy/use-style styles/button)
   [button/primary-small {:content name
                          :on-click-fn #()}]])

(defn calculator []
  [:div (stylefy/use-style styles/main-container)
   [:div (stylefy/use-style styles/output-grid)
    [areas/shadow-area {:styles styles/output-field}
     [:span "666"]]
    [function-button "="]]

   [:p]

   [:div (stylefy/use-style styles/function-grid)
    [function-button "+"]
    [function-button "-"]
    [function-button "*"]
    [function-button "/"]]

   [:p]

   [:div (stylefy/use-style styles/number-grid)
    [number-button 1]
    [number-button 2]
    [number-button 3]
    [number-button 4]
    [number-button 5]
    [number-button 6]
    [number-button 7]
    [number-button 8]
    [number-button 9]
    [number-button 0]]])