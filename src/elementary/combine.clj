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
    (= (resolved39WithConcat [30 20] [25 15]) [30 25 20 15])
    ))

; BEST
;(defn Solution [s1 s2] (flatten (map #(list %1 %2)  s1 s2)))

(defn reduce-right-test [f coll]
  (loop [[c & cs] coll rvsd '()]
    (println "---" c cs rvsd)
    (if (nil? cs)
      (loop [acc c [r & rs] rvsd]
        (if r (recur (f r acc) rs) acc))
      (recur cs (cons c rvsd)))))

(reduce-right-test #(concat %2 (list %1)) [1 2 3 4])


;Problem 40, Interpose a Seq
(defn resolved40WithConcat
  [symbol second]
  (drop-last (reduce (fn
                       [accum args]
                       (concat accum [args symbol])
                       ) '() second)))
(defn problem40
  []
  (and
    (= (resolved40WithConcat 0 [1 2 3]) [1 0 2 0 3])
    (= (apply str (resolved40WithConcat ", " ["one" "two" "three"])) "one, two, three")
    (= (resolved40WithConcat :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
    ))


(defn resolved41WithConcat
  [coll number]
  (reduce-kv (fn
               [accum key args]
               (if (zero? (mod (+ key 1) number))
                 accum
                 (conj accum args)
                 )) [] coll))

(defn resolved41WithRecur [s n]
  (if (empty? s)
    s
    (concat (take (- n 1) s)
            (resolved41WithRecur (drop n s) n))))
(defn problem41
  []
  (and
    (= (resolved41WithConcat [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
    (= (resolved41WithRecur [:a :b :c :d :e :f] 2) [:a :c :e])
    (= (resolved41WithConcat [1 2 3 4 5 6] 4) [1 2 3 5 6])
    ))


;Problem 43, Reverse Interleave
(defn resolved43 [s n]
  (if (empty? s)
    s
    (concat (take (- n 1) s)
            (resolved41WithRecur (drop n s) n))))
(defn problem43
  []
  (and
    (= (resolved43 [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
    (= (resolved43 (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
    (= (resolved43 (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))
    ))



