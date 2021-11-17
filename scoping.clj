; SCOPING

(let [x 5 y 10]
    (println "x" x "y" y)
    (let [x 7 z 14]
        (println "x" x "y" y "z" z) ; x binds to 7
    )
    (println "x" x "y" y)
    ; (println "z" z) ; z does not exist in this scope
)
