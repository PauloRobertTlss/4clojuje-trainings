(ns elementary.factorial)
;Problem 42, Factorial Fun
;Write a function which calculates factorials.

; =/ no work
(defn resolved42
  [number]
  (reduce (fn [accum n]
             (print n)
              (if (zero? (- n 1))
                1
                (+ accum (* n (- n 1))))
               ) 0 (reverse (range 1 (inc number))))
    )


;BEST - copy from  site
(defn resolved42copy
  [arg] (apply * (range 1 (inc arg))))

(defn myfac[x]
  (if (= x 1) 1
              (* x (myfac (- x 1)))))

(defn problem42
  []
  (and
    (= (myfac 1) 1)
    (= (myfac 3) 6)
    (= (myfac 5) 120)
    (= (myfac 8) 40320)
    ))
