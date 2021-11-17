; OPERATIONS

(let [x 2 y 4] ; local binding [symbol <expressions> symbol <expression> ...]
    (println "x =" x ", y =" y)
    (println "x + y:" (+ x y)) ; addition
    (println "x - y:" (- x y)) ; subtraction
    (println "x * y:" (* x y)) ; multiplication
    (println "x / y:" (/ x y)) ; division
    (println "x == y:" (= x y)) ; equals
    (println "x < y:" (< x y)) ; less than
    (println "x > y:" (> x y)) ; greater than
    (println "x <= y:" (<= x y)) ; less than or equal to
    (println "x >= y:" (>= x y)) ; greater than or equal to
    (println "x + 1:" (inc x)) ; increment (by 1)
    (println "x - 1:" (dec x)) ; decrement (by 1)
    (println "x != y:" (not (= x y))) ; not equal
    (println "(concat [1 2] [3 4]):" (concat [1 2] [3 4])) ; concatenation
    (println "(str 213):" (str 213)) ; cast as string
    (println "(format %.2.f (* 3.14 2 2)):" (format "%.2f" (* 3.14 2 2))) ; format string
)   