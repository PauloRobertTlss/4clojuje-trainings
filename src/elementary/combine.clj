(ns elementary.combine)

;Problem 39, Interleave Two Seqs

(defn resolved39
  [first second]
  (reverse (reduce-kv (fn
                        [accum key args]
                        (let [next (nth second key nil)]
                          (if (nil? next)
                            accum
                            (conj (conj accum args) (nth second key))))
                        ) '() first)))

(defn resolved39WithConcat
  [first second]
  (reduce-kv (fn
               [accum key args]
               (let [next (nth second key nil)]
                 (if (nil? next)
                   accum
                   (concat accum [args (nth second key)])))
               ) '() first))

(defn problem39
  []
  (and
    (= (resolved39 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
    (= (resolved39WithConcat [1 2] [3 4 5 6]) '(1 3 2 4))
    (= (resolved39 [1 2 3 4] [5]) [1 5])
    (= (resolved39 [30 20] [25 15]) [30 25 20 15])
    ))


(defn reduce-right-test [f coll]
  (loop [[c & cs] coll rvsd '()]
    (println "---" c cs rvsd)
    (if (nil? cs)
      (loop [acc c [r & rs] rvsd]
        (if r (recur (f r acc) rs) acc))
      (recur cs (cons c rvsd)))))

(reduce-right-test #(concat %2 (list %1)) [1 2 3 4])