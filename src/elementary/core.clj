(ns elementary.core
   (:require [elementary.list :as elementList]
             [elementary.listconj :as listConj]
             [elementary.vector :as vect]
             [elementary.set :as set]
             [elementary.maps :as maps]
             [elementary.sequences :as sequences]
             [elementary.rest :as rest]
             [elementary.functions :as func]
             [elementary.double-down :as doubled]
             [elementary.hello-world :as hellow]
             [elementary.filters :as filters]
             [elementary.palindrome :as palindrome]
             [elementary.letters_caps :as letters]
             )
  (:gen-class))

;🟢

(defn -main
  "I don't do a whole lot ... yet."
  [& _]
  (println "Hello, World!")
  (println "Problem 4: " (elementList/problem4))
  (println "Problem 5: " (listConj/problem5))
  (println "Problem 6: " (vect/problem6))
  (println "Problem 7: " (vect/problem7))
  (println "Problem 8: " (set/problem8))
  (println "Problem 9: " (set/problem9))
  (println "Problem 10: " (maps/problem10))
  (println "Problem 11: " (maps/problem11))
  (println "Problem 12: " (sequences/problem12))
  (println "Problem 13: " (rest/problem13))
  (println "Problem 14: " (func/problem14))
  (println "Problem 15: " (doubled/problem15))
  (println "Problem 16: " (hellow/problem16))
  (println "Problem 17: " (maps/problem17))
  (println "Problem 18: " (filters/problem18))
  (println "Problem 19: " (elementList/problem19))
  (println "Problem 20: " (elementList/problem20))
  (println "Problem 21: " (elementList/problem21))
  (println "Problem 22: " (elementList/problem22))
  (println "Problem 22-1: " (elementList/problem22-1))
  (println "Problem 23: " (sequences/problem23))
  (println "Problem 24: " (sequences/problem24))
  (println "Problem 25: " (sequences/problem25))
  (println "Problem 26: " (sequences/problem26))
  (println "Problem 27: " (palindrome/problem27))
  (println "Problem 28: " (sequences/problem28))
  (println "Problem 29: " (letters/problem29))
  (println "Problem 30: " (sequences/problem30))
  (println "Problem 31: " (sequences/problem31))
  ;https://4clojure.oxal.org/#/problem/14
  )
