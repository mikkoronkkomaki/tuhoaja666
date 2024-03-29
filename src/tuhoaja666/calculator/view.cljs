(ns tuhoaja666.calculator.view
  (:require [re-frame.core :as re-frame]
            [stylefy.core :as stylefy]
            [tuhoaja666.calculator.controller]
            [tuhoaja666.calculator.model :as model]
            [tuhoaja666.calculator.styles :as styles]
            [velho-ds.atoms.area :as areas]
            [velho-ds.atoms.button :as button]))

(defn number-button
  ([number]
   (number-button false number))
  ([wide? number]
   [:div (stylefy/use-style (if wide?
                              styles/wide-button
                              styles/button))
    [button/primary-small {:content (str number)
                           :on-click-fn #(re-frame/dispatch [model/append-value number])}]]))

(defn function-button [name function-fn]
  [:div (stylefy/use-style styles/button)
   [button/primary-small {:content name
                          :on-click-fn function-fn}]])

(defn current-value []
  (let [current-value (re-frame/subscribe [model/current-value])]
    [:div (stylefy/use-style styles/output-grid)
     [areas/shadow-area {:styles styles/output-field}
      [:span @current-value]]]))

(defn calculator []
  [:div (stylefy/use-style styles/main-container)
   (current-value)

   [:p]

   [:div (stylefy/use-style styles/function-grid)
    [function-button "=" #(re-frame/dispatch [model/evaluate])]
    [function-button "C" #(re-frame/dispatch [model/reset])]]

   [:p]

   [:div (stylefy/use-style styles/numpad-grid)
    [number-button 1]
    [number-button 2]
    [number-button 3]
    [function-button "+" #(re-frame/dispatch [model/add])]
    [number-button 4]
    [number-button 5]
    [number-button 6]
    [function-button "-" #(re-frame/dispatch [model/substract])]
    [number-button 7]
    [number-button 8]
    [number-button 9]
    [function-button "*" #(re-frame/dispatch [model/times])]
    [number-button true 0]
    [function-button "/" #(re-frame/dispatch [model/division])]]])