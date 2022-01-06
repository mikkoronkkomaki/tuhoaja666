(ns tuhoaja666.calculator.styles
  (:require [velho-ds.tokens.font :as font]
            [velho-ds.tokens.font-size :as font-size]))

(def main-container
  {:padding-top "2rem" })

(def button
  {:display "grid"})

(def wide-button
  (merge button {:grid-column "1 / 4"}))

(def output-grid
  {:display "inline-grid" ;
   :grid-template-rows "40px"
   :grid-template-columns "100px 40px"
   :grid-gap "1px"
   :justify-items "center"
   :align-items "center"})

(def output-field
  {:font-family font/font-family-heading
   :font-size font-size/font-size-x-large
   :width "12rem"
   :text-align "right"})

(def function-grid
  {:display "inline-grid" ;
   :grid-template-rows "40px"
   :grid-template-columns "40px 40px"
   :grid-gap "1px"
   :justify-items "center"
   :align-items "center"})

(def numpad-grid
  {:display "inline-grid"
   :grid-template-rows "40px 40px 40px"
   :grid-template-columns "40px 40px 40px 60px"
   :grid-gap "1px"
   :justify-items "center"
   :align-items "center"})