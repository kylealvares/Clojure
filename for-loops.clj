; FOR LOOPS

; loop 1 - 10
(println (for [i (range 1 8)] i))

; loop through a list
(def nums (list :a :b :c :d :e))
(println (for [x nums] x))

; loop through vec
(def letters [\a \b \c \d \e \f \g])
(println (for [x letters] x))

; loop through a map
(def students [{:name "Jack" :grade 90 :course "Math"}
               {:name "Jill" :grade 88 :course "English"}
               {:name "Joe" :grade 79 :course "English"}])
(println (for [x students] (get x :name)))

; nested loops
(println (for [x [1 2] y [1 2]] [x y]))

; when
(println (for [x (range 10) :when (even? x)] x))

; while
(println (for [x (range) :while (< x 8)] x))

; functions
(println (for [x (range 5)] (* x x)))