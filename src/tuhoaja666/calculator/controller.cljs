(ns tuhoaja666.calculator.controller
  (:require [re-frame.core :as re-frame]
            [tuhoaja666.calculator.model :as model]))

(re-frame/reg-sub
  model/current-value
  (fn [db]
    (get-in db model/current-value-path)))

(defn append-to-current-value [db [_ value]]
  (def value value)
  (update-in db model/current-value-path #(js/parseInt (str % value))))
(re-frame/reg-event-db model/append-to-current-value append-to-current-value)