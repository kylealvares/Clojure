; LOOPS

; (loop [bindings] (body))

(loop [i 0 j 0]
    (when (< i 3)
        (println i j)
        (recur (inc i) (+ j 10))
    )
)

(defn func [max]
    (loop [i max result []]
        (if (zero? i)
            result 
            (recur (dec i) (conj result i))
        )
    )
)

(println (func 5))