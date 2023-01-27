(ns elementary.regex)
;Problem 34, Implement range

(def resolved37 "ABC")
;Problem 37, Regular Expressions
(defn problem37
  []                                                        ;
  (and
    (= resolved37 (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
    ))