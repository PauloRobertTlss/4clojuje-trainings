(ns elementary.filters)

;4everClojure
;Problem, 18
;(= __ (filter #(> % 5) '(3 4 5 6 7)))
(defn problem18
  []
  (= (list 6 7) (filter #(> % 5) '(3 4 5 6 7)))
  )
