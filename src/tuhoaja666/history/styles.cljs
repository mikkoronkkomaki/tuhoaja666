(ns tuhoaja666.history.styles
  (:require [velho-ds.tokens.font :as font]
            [velho-ds.tokens.font-size :as font-size]))

(def main-container
  {:padding-top "2rem"})

(def clause
  {:font-family font/font-family-heading
   :font-size font-size/font-size-x-large
   :width "12rem"
   :text-align "center"})

(def history-grid
  {:display "inline-grid" ;
   :grid-template-rows "40px"
   :grid-gap "1px"
   :justify-items "center"
   :align-items "center"})