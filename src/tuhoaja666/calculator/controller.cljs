(ns tuhoaja666.calculator.controller
  (:require [re-frame.core :as re-frame]
            [tuhoaja666.calculator.model :as model]
            [clojure.spec.alpha :as s]))

(def default-state {:current-value 0
                    :clause []})
(def max-input-value 10000)

(re-frame/reg-sub
  model/current-value
  (fn [db]
    (get-in db model/current-value-path)))

(defn append-value [db [_ value]]
  (let [old-value (get-in db model/current-value-path)
        new-value (js/parseInt (str old-value value))
        new-value (if (> new-value max-input-value)
                    old-value
                    new-value)]
    (assoc-in db model/current-value-path new-value)))
(re-frame/reg-event-db model/append-value append-value)

(defn reset [db _]
  (assoc-in db model/base-path default-state))
(re-frame/reg-event-db model/reset reset)

(defn add-operator [db operator]
  (let [current-value (get-in db model/current-value-path)]
    (-> db
        (update-in model/clause-path #(concat % [current-value operator]))
        (assoc-in model/current-value-path 0))))

(defn add [db _]
  (add-operator db +))
(re-frame/reg-event-db model/add add)

(defn substract [db _]
  (add-operator db -))
(re-frame/reg-event-db model/substract substract)

(defn times [db _]
  (add-operator db *))
(re-frame/reg-event-db model/times times)

(defn division [db _]
  (add-operator db /))
(re-frame/reg-event-db model/division division)

(defn evaluate-clause [clause]
  (assert (s/valid? ::model/clause clause)
          (str "Invalid clause. Will not evaluate: " (s/explain-str ::model/clause clause)))
  (:previous-value
    (reduce
      (fn [{:keys [previous-value operator] :as acc} current]
        (if (fn? current)
          (assoc acc :operator current)
          {:previous-value (operator previous-value current)}))
      {:previous-value (first clause)}
      (rest clause))))

(defn evaluate [db _]
  (let [clause (conj (vec (get-in db model/clause-path))
                     (get-in db model/current-value-path))
        result (evaluate-clause clause)]
    (-> db
        (assoc-in model/current-value-path result)
        (assoc-in model/clause-path []))))
(re-frame/reg-event-db model/evaluate evaluate)

