(ns tuhoaja666.calculator.controller-test
  (:require [clojure.test :refer [deftest is testing]]
            [tuhoaja666.calculator.controller :as controller]))

(deftest evaluate-clause
  (testing "Valid clauses"
    (is (= 3 (controller/evaluate-clause [1 + 2])))
    (is (= 5 (controller/evaluate-clause [2 * 2 + 1]))))

  (testing "Invalid clauses"
    (try
      (controller/evaluate-clause [2 str 2])
      (is false "Trying to evaluate an invalid clause should throw an exception")
      (catch :default e
        (is true "Trying to evaluate an invalid clause should throw an exception")))))

