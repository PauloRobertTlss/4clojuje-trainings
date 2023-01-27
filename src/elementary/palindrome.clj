(ns elementary.palindrome
  (:require [clojure.string :as str]))


(defn palindrome?
  [args]
    (if (string? args)
      (= args (clojure.string/reverse args))
      (= args (reverse args)))
    )

(defn problem27
  []
  (and
    (false? (palindrome? '(1 2 3 4 5)))
    (true? (palindrome? "racecar"))
    (true? (palindrome? [:foo :bar :foo]))
    (true? (palindrome? '(1 1 3 3 1 1)))
    (false? (palindrome? '(:a :b :c)))
    ))
