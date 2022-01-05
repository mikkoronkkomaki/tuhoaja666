(ns tuhoaja666.routes
  (:require [tuhoaja666.calculator.view :as calculator-view]
            [tuhoaja666.history.view :as history-view]))

(def routes
  [["/"
    {:name ::calculator
     :view calculator-view/calculator}]

   ["/history"
    {:name ::history
     :view history-view/history-page}]])
