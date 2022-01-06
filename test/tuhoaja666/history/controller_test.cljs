(ns tuhoaja666.history.controller-test
  (:require [clojure.test :refer [deftest is testing]]
            [tuhoaja666.history.controller :as controller]))

(deftest formatted-clauses
  (is (= ["1 + 1 = 2"] (controller/formatted-clauses [{:clause [1 + 1] :result 2}])))
  (is (= ["3 + 3 = 6" "1 + 1 = 2"] (controller/formatted-clauses [{:clause [1 + 1] :result 2}
                                                                  {:clause [3 + 3] :result 6}]))))
