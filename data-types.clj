; DATA TYPES

; comment
(println "Integer:" 1)
(println "Double:" 3.14)
(println "Negative:" -1)
(println "String:" "sample text")
(println "Character:" \a)
(println "Boolean:" true)
(println "Nil:" nil)
(println "Keyword:" :keyword)
(println "Linked-List:" (list 1 3 "a")) ; ()
(println "Hash-Map:" (hash-map :key "value" "b" 2)) ; {}
(println "Vector:" (vector 1 2 "c")) ; []
(println "Set:" (set [1, 1, 2, "A"])) ; #{}
(println "Quote:" '(list 1 2 3)) ; ' - supresses evaluation

; variables
; (def x 1)
; (println "Symbol:" x)

; functions
; (def func (fn [x] body...))
; fn - function
; [x] - list of parameters
; body - to be executed, last line returned
; (fn 1) - calling fn with parameter 1
; (defn func [x] body)