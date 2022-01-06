(ns tuhoaja666.history.model)

;; Paths
(def base-path [:history])
(def clauses-path (conj base-path :clauses))

;; Subscriptions
(def clauses :history/clauses)
(def formatted-clauses :history/formatted-clauses)

;; Events
(def reset :history/reset)
(def add-clause :history/add-clause)

