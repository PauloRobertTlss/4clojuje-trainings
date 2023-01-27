(ns elementary.sequences)

; #Problem
;(= __ (first '(3 2 1)))
(def resolved12 3)
(defn problem12_1
  []
  (= resolved12 (first '(3 2 1))))

; #Problem
;(= __ (second [2 3 4]))
(defn problem12_2
  []
  (= resolved12 (second '(2 3 1))))

; #Problem
;(= __ (last (list 1 2 3)))
(defn problem12_3
  []
  (= resolved12 (last '(1 2 3))))

(defn problem12
  []
  (and (problem12_1) (problem12_2) (problem12_3)))






;Reverse a Sequence | without [reverse]
(defn resolved23
  ([args] (resolved23 args []))
  ([args reversed]
   (let [itens (empty? args)]
     (if (not itens)
       (recur (drop-last args) (conj reversed (last args)))
       reversed
       ))))

(defn problem23
  []
  (and
    (= (resolved23 [1 2 3 4 5]) [5 4 3 2 1])
    (= (resolved23 (sorted-set 5 7 2 7)) '(7 5 2))
    (= (resolved23 [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])
    ))


; Sum it All UP - Question 24

(defn problem24
  []
  (and
    (= (reduce + [1 2 3]) 6)
    (= (reduce + (list 0 -2 5 5)) 8)
    (= (reduce + #{4 2 1}) 7)
    (= (reduce + '(0 0 -1)) -1)
    (= (reduce + '(1 10 3)) 14)
    ))


;Problem 25, Find the odd numbers
(defn problem25
  []
  (and
    (= (filter #(not (even? %)) #{1 2 3 4 5}) '(1 3 5))
    (= (filter #(not (even? %)) [4 2 1 6]) '(1))
    (= (filter #(not (even? %)) [2 2 4 6]) '())
    (= (filter #(not (even? %)) [1 1 1 3]) '(1 1 1 3))
    ))


;Problem 26, Fibonacci Sequence
; =/ .. no resolved

(defn friend26
  [args]
  (take args
        ((fn r [a b]
           (lazy-seq (cons a (r b (+ a b)))))
         1 1)))


(defn problem26
  []
  (and
    (= (friend26 3) '(1 1 2))
    (= (friend26 6) '(1 1 2 3 5 8))
    (= (friend26 8) '(1 1 2 3 5 8 13 21))
    ))


;Problem 28, Flatten a Sequence

(defn resolved28
  [x]
  (if (sequential? x)
    (mapcat resolved28 x)
    [x]))

(defn problem28
  []
  (and
    (= (resolved28 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
    (= (resolved28 ["a" ["b"] "c"]) '("a" "b" "c"))
    (= (resolved28 '((((:a))))) '(:a))
    ))


;Problem 30, Compress a Sequence
(defn resolved30
  [args]
  (reduce (fn
            [accum first]
            (if (= (last accum) first)
              accum
              (conj accum first))) [] args))

(defn problem30
  []
  (and
    (= (apply str (resolved30 "Leeeeeerrroyyy")) "Leroy")
    (= (resolved30 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
    (= (resolved30 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
    ))

;Problem 31, Pack a Sequence

(defn resolved31
  [args]
  (reduce (fn
            [accum currency]
            (if (nil? (get accum currency nil))
              (conj accum  {currency currency} )
              (update-in accum currency currency))) [] args))

(defn problem31
  []
  (and
    (println (resolved31 [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
    (println (resolved31 [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
    (println (resolved31 [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
    ))