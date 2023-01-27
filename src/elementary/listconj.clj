(ns elementary.listconj)

;4everClojure
(def listB (list 2 3 4))
(def listC (list 3 4))

(defn resolved
  []
  (list 1 2 3 4))

(defn problem5
  []
  (and
    (= (resolved) (conj listB 1))
    (= (resolved) (conj listC 2 1)))
  )
