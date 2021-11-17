; FUNCTIONS

; (defn funtion-name documentation [parameters]
    ; body
    ; last value returned
; )

; (function-name arg1 ...)

(defn hello [name] 
    (str "Hello " name)
)

(println (hello "John"))

(defn add "returns the sum of two numbers" [a b]
    (+ a b)
)

(println (add 1 3))
(println (:doc (meta (var add)))) ; get documentation of function

; arity methods (different number of parameters)

(defn greeting 
    ([] (println "Hello"))
    ([name] (println "Hello " name))
    ([name title] (println "Hello" title name))
)

(greeting)
(greeting "Smith")
(greeting "Smith" "Mr.")

; anonymous functions
; (fn [a b] (* a b)) ; function without a name
(let [func (fn [a b] (* a b))]
    (println (func 1 2))
)

; shorthand anonymous functions
; % - first and only arugment
; %1, %2, %3 multiple arguments
; #(str "Hello" %)
; #(str "Goodbye" %1 %2)
(let [func #(str "Goodbye " %1 " " %2)]
    (println (func "John" "Smith"))
)

; sample function
(defn area
    ([] (area 1 1))
    ([length] (area length 1))
    ([length width] (* length width))
)

(println (area))
(println (area 3))
(println (area 3 2))
