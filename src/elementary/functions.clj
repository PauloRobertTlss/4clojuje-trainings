(ns elementary.functions)

;4everClojure
(defn resolved14WithFunction
  [number]
  (+ number 5))

(def resolved14Number 8)

;Problem, 14
;(= __ ((fn add-five [x] (+ x 5)) 3)) ; use lambda
;
(defn problem14
  []
  (and
    (= resolved14Number ((fn add-five [x] (+ x 5)) 3))
    (= resolved14Number ((fn [x] (+ x 5)) 3))
    (= resolved14Number (#(+ % 5) 3))
    (= resolved14Number ((partial + 5) 3))))