(ns elementary.vector)

;4everClojure
(def listD (list :a :b :c))
(def vectorA (vec '(:a :b :c)))
(def vectorB (vector :a :b :c))

(defn resolved6
  []
  [:a :b :c])

(defn problem6
  []
    (= (resolved6) listD vectorA vectorB)
  )

(defn resolved7
  []
  [1 2 3 4])

(def vectorC (vector 1 2 3))
(def vectorD (vector 1 2))

(defn problem7
  []
    (and (= (resolved7) (conj vectorC 4)) (= (resolved7) (conj vectorD 3 4)))
  )
