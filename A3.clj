; (println "Question 1")

(defn polynomial [a b c d]
    (fn [x] (+ (* a (* x (* x x))) (+ (* b (* x x)) (+ (* c x) d))))
)

; (println (fn? (polynomial 1.0 2.0 3.0 4.0)))
; (let [f (polynomial 1. 2. 3. 4.)] (println (f 1.5)))
; (let [f (polynomial 3.14 5.0 1.0 -9.0)]
;     (doseq [x [0. 2.5 -3.]]
;         (println (format "x=%.2f f(x)=%.2f" x (f x)))))

; (println "Question 2")

(defn derivative [a b c d]
    (fn [x] (+ (* 3 (* a (* x x))) (+ (* 2 (* b x)) c)))
)

; (println (fn? (derivative 1 2 3 4)))
; (let [f' (derivative 1. 2. 3. 4.)] (println (f' 1.5)))
;;; @check(q2-3)
; (let [f' (derivative 3.14 5.0 1.0 -9.0)]
;     (doseq [x [0. 2.5 -3.]]
;         (println (format "x=%.2f f'(x)=%.2f" x (f' x)))))

(defn newtons-method
    ([f f'] (newtons-method f f' {:iterations 100}))
    ([f f' stop-condition]
        (loop [i 0 xn 0.]
            (if (contains? stop-condition :iterations)
                (if (>= i (get stop-condition :iterations))
                    (hash-map :root xn :value (f xn) :iterations i)
                    (recur (inc i) (- xn (/ (f xn) (f' xn))))
                )
                (if (<= (max (f xn) (* (f xn) -1)) (get stop-condition :epsilon))
                    (hash-map :root xn :value (f xn) :iterations i)
                    (recur (inc i) (- xn (/ (f xn) (f' xn))))
                )
            )
        ) 
    )
)

(defn print-result [r]
    (println (format "f(%.5f) = %.6f after %d iterations" 
                     (:root r)
                     (:value r)
                     (:iterations r))))

(let [f (polynomial 1. 2. 3. 4.)
      f' (derivative 1. 2. 3. 4.)]
    (print-result (newtons-method f f' {:epsilon 1e-3})))

(let [f (polynomial 1. 2. 3. 4.)
      f' (derivative 1. 2. 3. 4.)]
    (print-result (newtons-method f f' {:iterations 2})))

(let [f (polynomial 1. 2. 3. 4.)
      f' (derivative 1. 2. 3. 4.)]
    (print-result (newtons-method f f')))