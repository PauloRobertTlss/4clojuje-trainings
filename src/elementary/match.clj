(ns elementary.match)
;Problem 34, Implement range

(def resolved35 7)
(defn problem35
  []
  (and
    (= resolved35 (let [x 5] (+ 2 x)))
    (= resolved35 (let [x 3, y 10] (- y x)))
    (= resolved35 (let [x 21] (let [y 3] (/ x y))))
    ))



(defn problem36
  []
  (and
    (= 10 (let [z 1 y 3 x 7] (+ x y)))
    (= 4 (let [z 1 y 3 x 7] (+ y z)))
    (= 1 (let [z 1 y 3 x 7] z))
    ))

;Problem 38, Maximum value
(defn maxThreadFirst
  [& args]
   (-> args
       (sort)
       (last))
)

(defn maxWithReduce
  [& se]
    (reduce #(if (> %1 %2)
               %1
               %2)  se))

(defn problem38
  []
  (and
    (= (maxThreadFirst 1 8 3 4) 8)
    (= (maxThreadFirst 30 20) 30)
    (= (maxWithReduce 45 67 11) 67)
    ))