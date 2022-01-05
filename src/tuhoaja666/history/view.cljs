(ns tuhoaja666.history.view
  (:require [stylefy.core :as stylefy]
            [tuhoaja666.history.styles :as styles]
            [velho-ds.molecules.field :as field]))

(defn history-page []
  [:div
   (stylefy/use-style styles/main-container)
   [field/multiline-field {:content (atom "1 + 1 = 666\n2 + 2 = 666\n3 + 3 = 666")
                           :on-change-fn #()}]])
