(ns elementary.double-down)

;4everClojure
;Problem, 15
;(= (__ 2) 4)
;
(defn problem15
  []
  (and
    (= ((partial * 2) 2) 4)
    (= ((partial * 2) 3) 6)
    (= ((partial * 2) 11) 22)
    (= ((partial * 2) 7) 14)))