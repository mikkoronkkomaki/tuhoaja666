(ns tuhoaja666.calculator.styles)

(def main-container
  {:padding-top "2rem"})

(def button
  {:display "grid"})

(def output-grid
  {:display "inline-grid" ;
   :grid-template-rows "40px"
   :grid-template-columns "100px 40px"
   :grid-gap "3px"
   :justify-items "center"
   :align-items "center"})

(def output-field
  {:font-size "1.25rem"})

(def function-grid
  {:display "inline-grid" ;
   :grid-template-rows "40px"
   :grid-template-columns "40px 40px 40px 40px"
   :grid-gap "3px"
   :justify-items "center"
   :align-items "center"})

(def number-grid
  {:display "inline-grid" ;
   :grid-template-rows "40px 40px 40px"
   :grid-template-columns "40px 40px 40px"
   :grid-gap "3px"
   :justify-items "center"
   :align-items "center"})