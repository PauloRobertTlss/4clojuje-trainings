(ns elementary.set)

;4everClojure

(def setA (set '(:a :a :b :c :c :c :c :d :d)))

(defn resolved8
  []
  (hash-set :a :b :c :d))

(defn problem8
  []
    (= (resolved8) setA)
  )


(def setB (hash-set 1 2 3 4))
(def setC (hash-set 1 4 3))

(defn problem9
  []
  (= setB (conj setC 2))
  )
