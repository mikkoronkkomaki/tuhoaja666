(ns tuhoaja666.calculator.model
  (:require [cljs.spec.alpha :as s]))

;; Paths
(def base-path [:calculator])
(def current-value-path (conj base-path :current-value))
(def clause-path (conj base-path :clause))

;; Subscriptions
(def current-value :calculator/current-value)

;; Events
(def append-value :calculator/append-value)
(def reset :calculator/reset)
(def add :calculator/add)
(def substract :calculator/substract)
(def times :calculator/times)
(def division :calculator/division)
(def evaluate :calculator/evaluate)

;; Specs
(s/def ::literal (s/or
                   :n number?
                   :f #{+ - / *}))
(s/def ::clause (s/coll-of ::literal))