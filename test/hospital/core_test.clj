(ns hospital.core-test
  (:require [clojure.test :refer :all]
            [hospital.model :as h.model]
            [hospital.logic :refer :all]
            [schema.core :as s]
            [clojure.test.check.generators :as gen]
            ))

;(s/set-fn-validation! true)


(deftest cabe-na-fila?-test-with-geradores
  (testing "Que não cabe na fila vazia"
    (doseq [fila (gen/sample (gen/vector gen/string-alphanumeric 0 4))]
      (is (cabe-na-fila? {:espera fila} :espera)))))