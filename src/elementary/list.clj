(ns elementary.list
  (:require [clojure.string :as str]))

;4everClojure
(def listA (list :a :b :c))

(defn problem4
  []
  (= listA '(:a :b :c))
  )


; Last item (without use [last]) | No work [get] in list,best [nth]
; (= (__ [1 2 3 4 5]) 5)
(defn resolved19WithCount
  [args]
  (nth args (- (count args) 1)))

(defn resolved19Native
  [args]
  (-> args
      (reverse)
      (first)))

(defn problem19
  []
  (and (= (resolved19WithCount [1 2 3 4 5]) 5)
    (= (resolved19Native '(5 4 3)) 3)))

; Penultimate Element item | No work [get] in list,best [nth]
; (= (__ [[1 2] [3 4]]) [1 2])
(defn resolved20
  [args] (-> args
             (reverse)
             (rest)
             (first)
             ))

(defn problem20
  []
  (and (= (resolved20 (list 1 2 3 4 5)) 4)
    (= (resolved20 ["a" "b" "c"]) "b")
    (= (resolved20 [[1 2] [3 4]]) [1 2])
    ))


; overwrite Nth, no use [NTH]
; (= (__ [[1 2] [3 4]]) [1 2])
(defn resolved21
  [args index]
  (if (= index 0)
    (first args)
    (recur (rest args) (- index 1))))

(defn problem21
  []
  (and (= (resolved21 '(4 5 6 7) 2) 6)
    (= (resolved21 [:a :b :c] 0) :a)
    (= (resolved21 [1 2 3 4] 1) 2)
    (= (resolved21 '([1 2] [3 4] [5 6]) 2) [5 6])

    ))


; overwrite Nth, no use [NTH]
; (= (__ [[1 2] [3 4]]) [1 2])
(defn resolved22
  [args index]
  (if (= index 0)
    (first args)
    (recur (rest args) (- index 1))))

(defn resolved22WithMap
  [args index]
    (first (filter (fn[f] (boolean f))
           (map-indexed (fn
                          [k, v]
                          (if (= k index)
                            v
                            nil)) args))))

; Mestre Jedi
(defn resolved22WithDrop
  [args index]
    (first (drop index args)))

(defn problem22
  []
  (and
    (= (resolved22 '(4 5 6 7) 2) 6)
    (= (resolved22 [:a :b :c] 0) :a)
    (= (resolved22WithMap [1 2 3 4] 1) 2)
    (= (resolved22WithDrop '([1 2] [3 4] [5 6]) 2) [5 6])
    ))


;Count a Sequence | without [count]
(defn resolved22-1
  ([args] (if (string? args)
             (resolved22-1 (str/split args "") 0)
             (resolved22-1 args 0)))
  ([args accum]
     (let [itens (empty? args)]
       (if (not itens)
         (recur (rest args) (+ accum 1))
         accum
         ))))


(defn problem22-1
  []
  (and
    (= (resolved22-1 '(1 2 3 3 1)) 5)
    (= (resolved22-1 "Hello World" 0) 11)
    (= (resolved22-1 [[1 2] [3 4] [5 6]]) 3)
    (= (resolved22-1 '(13)) 1)
    (= (resolved22-1 '(:a :b :c)) 3)
    ))


