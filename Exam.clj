; Question 2a

; (def f {:name "Jack"})
; (println (= (:name f) "Jack"))

; 2b 
; (println (type '(1 2 3)))
; (println (type #{1 2 3}))

; (println (= (:a #{:a :b}) (#{:a :b} :a)) )


; Question 3a
(defn inside? [x y]
    (if (< (+ (* x x) (* y y)) 1)
        true
        false
    )
)

; (println (inside? 0 0))
; (println (inside? -2 0))
; (println (inside? 2 0))
; (println (inside? 0 -2))
; (println (inside? 0 2))

; Question 3b


; from random import random
; def estimate_PI(n):
; |    in_circle_count = 0.0
; |    for i in range(n):
; |    |    x = random()
; |    |    y = random()
; |    |    if x*x + y*y < 1:
; |    |    |    in_circle_count += 1
; |    return (in_circle_count / n) * 4

(defn estimate-pi [n]
    (loop [total 0.0 i n]
        (if (> i 0)
            (let [x (rand) y (rand)]
                (if (inside? x y)
                    (recur (inc total) (dec i))
                    (recur total (dec i))
                )
            )
            (* (/ total n) 4)
        )
    )
)

; (println (estimate-pi 5))

(defn est-pi' [n]
    (let [xs (repeatedly n rand)
          ys (repeatedly n rand)
          f (fn [total] (* 4 (/ (double total) n)))]
        (->> apply 
          )))

; Question 4
(def bs [{:student "Jack"
  :takes [{:course "English" :grade 78}
          {:course "Math" :grade 80}
          {:course "Chemistry" :grade 90}]}
 {:student "Mary"
  :takes [{:course "Math" :grade 83}
          {:course "CS" :grade 87}
          {:course "English" :grade 88}
          {:course "Economics" :grade 75}]}
 {:student "Joe"
  :takes [{:course "CS" :grade 90}
          {:course "Math" :grade 80}]}])


; [{:course "English"
;   :taken-by [{:student "Mary", :grade 88}
;              {:student "Jack", :grade 78}]}
;  {:course "Math",
;   :taken-by [{:student "Joe", :grade 80}
;              {:student "Mary", :grade 83}
;              {:student "Jack", :grade 80}]}
;  {:course "Chemistry"
;   :taken-by [{:student "Jack", :grade 90}]}
;  {:course "CS",
;   :taken-by [{:student "Joe", :grade 90}    
;              {:student "Mary", :grade 87}]}
;  {:course "Economics"
;   :taken-by [{:student "Mary", :grade 75}]}]


(defn convert [by-student]
    (loop [students by-student course []]
        (if (empty? students)
            (do 
                (let [student (first students)]
                    (for [x (get student :takes)] 
                        (assoc course (get x :grade))
                    )
                )
                (recur (rest students) course)
            )
            course
        )
    )
)
(convert bs)