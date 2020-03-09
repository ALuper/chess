(ns chess.core-test
  (:require [clojure.test :refer [run-tests successful?]]
            [ysera.test :refer [deftest is]]
            [chess.core :refer :all]))

(deftest test-all
         "Bootstrapping with the required namespaces, finds all the chess.* namespaces (except this one),
         requires them, and runs all their tests."
         (let [namespaces (->> (all-ns)
                               (map str)
                               (filter (fn [x] (re-matches #"chess\..*" x)))
                               (remove (fn [x] (= "chess.core-test" x)))
                               (map symbol))]
           (is (successful? (time (apply run-tests namespaces))))))