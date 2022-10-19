(ns tuhoaja666.app.styles
  (:require [velho-ds.tokens.color :as color]
            [velho-ds.tokens.font :as font]
            [velho-ds.tokens.font-size :as font-size]
            [velho-ds.tokens.spacing :as spacing]))

(def main-container
  {:text-align "center"})

(def navigation-link
  {:align-self      "center"
   :text-decoration "none"
   :color           color/color-pinky-dark
   :padding         (str "0 " spacing/space-small-rem)})

(def navigation-label
  {:font-family     font/font-family-heading
   :font-size       font-size/font-size-x-large
   :align-self      "center"
   :text-decoration "none"
   :color           color/color-pinky-dark
   :padding         (str "0 " spacing/space-small-rem)})
