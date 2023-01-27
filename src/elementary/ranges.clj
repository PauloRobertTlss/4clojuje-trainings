(ns elementary.ranges)
;Problem 34, Implement range

(defn generateR
  ([start end] (generateR start end (vector)))
  ([start end accuml]
   (if (= start end)
     accuml
     (recur (inc start) end (conj accuml start))
     )))


(defn generateWithTake
  [start end]
  (take
     (- end start)
     (iterate inc start))
     )

(defn problem34
  []
  (and
    (= (generateR 1 4) '(1 2 3))
    (= (generateR -2 2) '(-2 -1 0 1))
    (= (generateWithTake 5 8) '(5 6 7))
    ))