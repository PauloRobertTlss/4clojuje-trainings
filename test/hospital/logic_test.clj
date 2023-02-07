(ns hospital.logic-test
  (:require [clojure.test :refer :all]
            [hospital.model :as h.model]
            [hospital.logic :refer :all]
            [schema.core :as s]
            [clojure.test.check.clojure-test :refer (defspec)]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.generators :as gen]
            ))

;(s/set-fn-validation! true)

(deftest cabe-na-fila?-test
  (testing "Que cabe na fila vazia"
    (is (cabe-na-fila? {:espera []}, :espera)))

  (testing "Que não cabe na fila vazia"
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5 6]}, :espera)))
    ))

(deftest cabe-na-fila?-test-with-geradores
  (testing "Que não cabe na fila vazia"
    (doseq [fila (gen/sample (gen/vector gen/string-alphanumeric 0 4) 20)]
      (println fila)
      (is (cabe-na-fila? {:espera fila} :espera)))))

(defspec chega-em-test-for 10
  (prop/for-all
    [fila (gen/vector gen/string-alphanumeric 0 4)
     pessoa gen/string-alphanumeric]
    (println fila pessoa)
    (is (= {:espera (conj fila pessoa)}
           (chega-em {:espera fila} :espera pessoa)))))


; retorna um gen
(def random-name-gen (gen/fmap clojure.string/join (gen/vector gen/char-alphanumeric 5 10)))

(defn transfere-ignorando-exceptions
  [hospital para]
  (try
    (transfere hospital :espera para)
    (catch clojure.lang.ExceptionInfo e
      (cond
        (= :fila-cheia (:type (ex-data e))) hospital
        :else (throw e))
      )))

(defn transfere-ignorando-exceptions-best
  [hospital para]
  (try
    (transfere hospital :espera para)
    (catch IllegalStateException e
      hospital
      )))

(defn transforme-vector-to-queue
  [vector]
   (reduce conj h.model/fila-vazia vector)
  )
(def fila-nao-cheia-gen (gen/fmap transforme-vector-to-queue (gen/vector random-name-gen 0 4)))

(defspec transfere-manter-quantidade-de-pessoas 1
  (prop/for-all
    [espera fila-nao-cheia-gen
     raio-x fila-nao-cheia-gen
     ultrasom fila-nao-cheia-gen
     vai-para (gen/elements [:raio-x :ultrason])
     ]
    (let [hospital-inicial {:espera espera :raio-x raio-x :ultrasom ultrasom}
          hospital-final (transfere-ignorando-exceptions hospital-inicial :espera vai-para)]
      (= (total-de-pacientes hospital-inicial)
         (total-de-pacientes hospital-final))
      )
    )
  )


(defspec transfere-manter-quantidade-de-pessoas-mult 1
  (prop/for-all
    [espera fila-nao-cheia-gen
     raio-x fila-nao-cheia-gen
     ultrasom fila-nao-cheia-gen
     vai-para (gen/vector (gen/elements [:raio-x :ultrason]) 10 50)
     ]
    (let [hospital-inicial {:espera espera :raio-x raio-x :ultrasom ultrasom}
          hospital-final
           (reduce transfere-ignorando-exceptions hospital-inicial vai-para)]
      (= (total-de-pacientes hospital-inicial)
         (total-de-pacientes hospital-final))
      )
    )
  )