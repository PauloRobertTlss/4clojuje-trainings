(ns elementary.maps)

;4everClojure

; #Problem
;(= _____ ((hash-map :a 10, :b 20, :c 30) :b)))
(def resolved10 20)
(defn problem10
  []
    (= resolved10 ((hash-map :a 10, :b 20, :c 30) :b)))

; #Problem
; (= {:a 1, :b 2, :c 3} (conj {:a 1} ____ [:c 3]))
(def resolved11 {:b 2})
(defn problem11
  []
    (= {:a 1, :b 2, :c 3} (conj {:a 1} resolved11 [:c 3]))
       )

;Problem 17
;(= __ (map #(+ % 5) '(1 2 3)))
(def resolved17 (list 6 7 8))
(defn problem17
  []
  (= resolved17 (map #(+ % 5) '(1 2 3))))