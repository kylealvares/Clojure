; Assignment 1

; Question 1
(println)
(println "Question 1")

(defn f [x y z]
    (/ (* x (+ x y)) z))

(println "input: 10 20 100")
(println "output: " (f 10 20 100))
(println)

; Question 2
(println "Question 2")

(defn make-list[]
    (list "clojure" (vector :foo :bar :baz) 3055))

(println "list: " (make-list))
(println "list-type: " (list? (make-list)))
(println "count: " (count (make-list)))
(println)

; Question 3
(println "Question 3")

(defn place [name abbrev population unit]
    (hash-map :name name :abbrev abbrev :population (vector population unit)))

(println (place "Ontario" "ON" 6 :million))