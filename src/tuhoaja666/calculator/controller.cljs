(ns tuhoaja666.calculator.controller
  (:require [cljs.spec.alpha :as s]
            [re-frame.core :as re-frame]
            [tuhoaja666.calculator.model :as calculator-model]
            [tuhoaja666.history.model :as history-model]))

(def default-state {:current-value 0
                    :clause []})
(def max-input-value 10000)

(re-frame/reg-sub
  calculator-model/current-value
  (fn [db]
    (get-in db calculator-model/current-value-path)))

(defn append-value [db [_ value]]
  (let [old-value (get-in db calculator-model/current-value-path)
        new-value (js/parseInt (str old-value value))
        new-value (if (> new-value max-input-value)
                    old-value
                    new-value)]
    (assoc-in db calculator-model/current-value-path new-value)))
(re-frame/reg-event-db calculator-model/append-value append-value)

(defn reset [db _]
  (assoc-in db calculator-model/base-path default-state))
(re-frame/reg-event-db calculator-model/reset reset)

(defn add-operator [db operator]
  (let [current-value (get-in db calculator-model/current-value-path)]
    (-> db
        (update-in calculator-model/clause-path #(concat % [current-value operator]))
        (assoc-in calculator-model/current-value-path 0))))

(defn add [db _]
  (add-operator db +))
(re-frame/reg-event-db calculator-model/add add)

(defn substract [db _]
  (add-operator db -))
(re-frame/reg-event-db calculator-model/substract substract)

(defn times [db _]
  (add-operator db *))
(re-frame/reg-event-db calculator-model/times times)

(defn division [db _]
  (add-operator db /))
(re-frame/reg-event-db calculator-model/division division)

(defn evaluate-clause [clause]
  (assert (s/valid? ::calculator-model/clause clause)
          (str "Invalid clause. Will not evaluate: " (s/explain-str ::calculator-model/clause clause)))
  (:previous-value
    (reduce
      (fn [{:keys [previous-value operator] :as acc} current]
        (if (fn? current)
          (assoc acc :operator current)
          {:previous-value (operator previous-value current)}))
      {:previous-value (first clause)}
      (rest clause))))

(defn evaluate [{:keys [db]} _]
  (let [clause (conj (vec (get-in db calculator-model/clause-path))
                     (get-in db calculator-model/current-value-path))
        result (evaluate-clause clause)]
    {:db (-> db
             (assoc-in calculator-model/current-value-path result)
             (assoc-in calculator-model/clause-path []))
     :dispatch [history-model/add-clause {:clause clause :result result}]}))
(re-frame/reg-event-fx calculator-model/evaluate evaluate)

