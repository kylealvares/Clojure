; VECTORS

(def a (vector "a" 1 :hello 3.14)) ; vectors can be heterogenous

(def v (vector 1 2 3 4 5 6 7)) ; stored in a tree

; vec - converts collection into vector
(println "\nvec - converts collection into vector")
(println "abcdef ->" (vec "abcdef"))
(println "[1 2 3 4] ->"(vec [1 2 3 4]))
(println "{:k1 :v1 :k2 :v2} ->" (vec {:k1 :v1 :k2 :v2}))

(println "\nv =" v)

; vector functions
(println "first:" (first v)) ; returns first element in vector
(println "last:" (last v)) ; returns last element in vector
(println "v[3]:" (nth v 3)) ; returns nth element in vector
(println "conj 8:" (conj v 8)) ; appends element to vector
(println "into [-1 0]:" (into [-1 0] v)) ; inserts vector
(println "concat [8 9]:" (vec (concat v [8 9]))) ; returns concatenated vetors as list
(println "rest:" (vec (rest v))) ; returns list after first element
