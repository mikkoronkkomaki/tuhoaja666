(ns tuhoaja666.history.controller
  (:require [tuhoaja666.history.model :as model]
            [re-frame.core :as re-frame]
            [clojure.string :as string]))

(def default-state {:clauses []})

(re-frame/reg-sub
  model/clauses
  (fn [db]
    (get-in db model/clauses-path)))

(defn formatted-clauses [clauses]
  (->> (map (fn [{:keys [clause result]}]
              (str
                (string/join
                  " "
                  ;; todo: This is dumb. Should be possible to achieve using symbols.
                  (map #(condp = %
                          + "+"
                          - "-"
                          * "*"
                          / "/"
                          %)
                       clause))
                " = "
                result))
            clauses)
       reverse))

(re-frame/reg-sub model/formatted-clauses
                  :<- [model/clauses]
                  formatted-clauses)

(defn reset [db _]
  (assoc-in db model/base-path default-state))
(re-frame/reg-event-db model/reset reset)

(defn add-clause [db [_ clause]]
  (update-in db model/clauses-path #(conj % clause)))
(re-frame/reg-event-db model/add-clause add-clause)