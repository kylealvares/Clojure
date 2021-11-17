; BRANCHING

; (if <condition>
;   (true-body)
;   (false-body)
; ) 
 
(let [x 10]
    (if (<= x 5)
        (println x "<= 5")
        (println x "> 5")
    )
)

; do allows for multiple statements to execute

(defn negate [x]
    (if (<= x 0)
        (do
            (println x "is negative")
            (* x -1) 
        )
        (do 
            (println x "is positive")
            (* x -1)
        )
    )
)

(println (negate 5))

; and 
(let [grade1 70 grade2 95]
    (if (and (> grade1 50) (> grade2 50))
        (println "passed")
        (println "failed")
    )
)

; or 
(let [grade1 45 grade2 75]
    (if (or (> grade1 50) (> grade2 50))
        (println "passed")
        (println "failed")
    )
)

; switch / cond
(let [grade 84]
    (cond 
        (>= grade 80) (println "A")
        (>= grade 70) (println "B")
        (>= grade 60) (println "C")
        (>= grade 50) (println "D")
        :else (println "F")
    )
)
