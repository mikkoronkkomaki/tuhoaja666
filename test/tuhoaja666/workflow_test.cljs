(ns tuhoaja666.workflow-test
  (:require [clojure.test :refer [deftest is testing]]
            [day8.re-frame.test :as rf-test]
            [re-frame.core :as rf]
            [tuhoaja666.calculator.model :as calculator-model]
            [tuhoaja666.history.model :as history-model]))

(deftest calculation
  (rf-test/run-test-sync
    (let [current-value (rf/subscribe [calculator-model/current-value])]
      (rf/dispatch [calculator-model/reset])
      (is (= 0 @current-value) "Initial value should be 0")
      (rf/dispatch [calculator-model/append-value 666])
      (is (= 666 @current-value) "The new value should be updated")
      (rf/dispatch [calculator-model/add])
      (rf/dispatch [calculator-model/append-value 1])
      (rf/dispatch [calculator-model/evaluate])
      (is (= 667 @current-value) "The evaluation should yield expected result"))))

(deftest history
  (rf-test/run-test-sync
    (let [clauses (rf/subscribe [history-model/formatted-clauses])]
      (rf/dispatch [calculator-model/reset])
      (rf/dispatch [calculator-model/append-value 2])
      (rf/dispatch [calculator-model/add])
      (rf/dispatch [calculator-model/append-value 1])
      (rf/dispatch [calculator-model/evaluate])
      (is (= ["2 + 1 = 3"] @clauses) "The evaluated clause should be stored and returned as formatted"))))