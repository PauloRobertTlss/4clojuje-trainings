(ns elementary.combine)
;Problem 34, Implement range

(def resolved35 7)
(defn problem35
  []
  (and
    (= resolved35 (let [x 5] (+ 2 x)))
    (= resolved35 (let [x 3, y 10] (- y x)))
    (= resolved35 (let [x 21] (let [y 3] (/ x y))))
    ))


