(ns elementary.letters_caps)

;Problem 29, Get the Caps | with regex
(defn onlyletters
  [args]
    (clojure.string/replace args #"[^A-Z]" ""))

(defn problem29
  []
  (and
    (= (onlyletters "HeLlO, WoRlD!11") "HLOWRD")
    (empty? (onlyletters "nothing"))
    (= (onlyletters "$#A(*&987Zf") "AZ")
    ))

 (println problem29)