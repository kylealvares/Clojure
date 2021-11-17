; DOSEQ

(doseq [x (range 2) y (range 2) :when (= x y)]
    (println x y)
)

(dotimes [n 10]
    (print n " ")
)

(println "")