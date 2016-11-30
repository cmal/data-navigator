(ns data-navigator.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [data-navigator.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
