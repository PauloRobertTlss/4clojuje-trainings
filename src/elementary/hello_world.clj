(ns elementary.hello-world
  (:require [clojure.string :as str]))

;4everClojure
;Problem, 16
;
(defn problem16
  []
   (and (= ((fn [s] (str "Hello, " s "!")) "Dave") "Hello, Dave!")
   (= ((fn [s] (str/replace "Hello, @!" "@" s)) "Dave") "Hello, Dave!")))
