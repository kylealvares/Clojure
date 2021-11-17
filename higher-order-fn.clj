; HIGHER ORDER FUNCTIONS

; variadic functions - multiple fixed parameters for function
(defn add-vard 
    ([a b] (+ a b))
    ([a b c] (+ a b c))
    ([a b c d] (+ a b c d))
)    

; (println (add-vard 1 2))
; (println (add-vard 1 2 3))
; (println (add-vard 1 2 3 4))

; default values for variadic functions
(defn area 
    ([length] (area length 1))
    ([length width] (* length width))
)
; (println (area 2))
; (println (area 2 2))

(defn sum [x & others] ; & - unknown amount of parameters
    (loop [sum x values others]
        (if (empty? values)
            sum 
            (recur (+ sum (first others)) (rest values))
        )
    )
)
; (println (sum 1 2 3 4))

; (defn add [x y z]
;     (+ x y z)
; )

; (let [numbers [1 2 3]]
;     (println (apply add numbers))
; )


