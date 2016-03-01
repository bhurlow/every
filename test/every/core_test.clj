(ns every.core-test
  (:require [clojure.test :refer :all]
            [every.core :refer :all]))

(deftest extract
  (testing "extract amount"
    (is (= 123 (extract-amount "123d"))))
  (testing "extract-unit"
    (is (= :d (extract-unit "123d")))))

(deftest a-test
  (testing "interval parsing"
    (is (= 50   (parse-interval 50)))
    (is (= 1000 (parse-interval "1s")))
    (is (= (* 60 1000) (parse-interval "1m")))
    (is (= (* 60 (* 60 1000) (parse-interval "1h"))))
    (is (= (* 24 (* 60 (* 60 1000)) (parse-interval "1d"))))))

(deftest badinput
  (testing "throw"
    (is (thrown? Exception (parse-interval "123bbb")))))


