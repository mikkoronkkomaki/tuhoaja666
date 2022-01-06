(ns tuhoaja666.calculator.model)

;; Paths
(def base-path [:calculator])
(def current-value-path (conj base-path :current-value))

;; Subscriptions
(def current-value :calculator/current-value)

;; Events
(def append-to-current-value :calculator/add-to-current-value)