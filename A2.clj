(println "Question 1: ")

(defn make-poly [variable coefficients]
    (if (= (first coefficients) 0)
        (recur variable (drop 1 coefficients))
        {:variable variable :coefficients coefficients}
    )
)

(println (make-poly "y" [1 2 3 4]))
(println (make-poly "x" [3 0 4 2 0]))
(println (make-poly "x" [0 0 3 2 1 0 0]))

(println "Question 2: ")

(defn degree [poly] 
    (dec (count (poly :coefficients)))
)

(let [poly {:variable "y"
            :coefficients [1 2 3 4]}]
    (println (degree poly)))
(let [poly {:variable "x"
            :coefficients [3]}]
    (println (degree poly)))

(println "Question 3")

(defn exponents-of-poly [poly]
    (reverse (range 0 (count (poly :coefficients))))
)

(let [poly {:variable "y"
            :coefficients [1 2 3 4]}]
    (println (vec (exponents-of-poly poly))))

(println "Question 4")

(defn terms-of-poly [poly]
    (loop [i (dec (count (poly :coefficients))) j 0 terms () coefficients (poly :coefficients)]
        (if (< i 0)
            terms
            (recur (dec i) (inc j) (conj terms [(nth coefficients i) (poly :variable) j]) coefficients)
        )
    )
)       

(let [poly {:variable "y"
            :coefficients [1 2 3 4]}]
    (println (vec (terms-of-poly poly))))

(let [poly {:variable "y"
            :coefficients [4]}]
    (println (vec (terms-of-poly poly))))

(println "Question 5")

(defn format-term [term]
    (if (= (last term) 0)
        (format "%d" (first term))
        (if (= (first term) 1)
            (format "%s^%d" (nth term 1) (last term))
            (if (= (first term) 0)
                nil
                (format "%d%s^%d" (first term) (nth term 1) (last term))
            )
        )
    )
)

(println (format-term [2 "x" 3]))
(println (format-term [0 "x" 3]))
(println (format-term [1 "x" 3]))
(println (format-term [2 "x" 0]))

(println "Question 6")

(defn format-poly [poly]
    (def first-term (format-term [(first (poly :coefficients)) (poly :variable) (dec (count (poly :coefficients)))]))
    (loop [i 1 j (- (count (poly :coefficients)) 2) formatted first-term coefficients (poly :coefficients)]
        (if (>= i (count (poly :coefficients)))
            formatted
            (do 
                (def term (format-term [(nth coefficients i) (poly :variable) j]))
                (if (= term nil)
                    (recur (inc i) (dec j) (str formatted "") coefficients)
                    (if (> (nth coefficients i) 0)
                        (recur (inc i) (dec j) (str formatted "+" term) coefficients)
                        (recur (inc i) (dec j) (str formatted term) coefficients)
                    )
                )
            )
        )
    )
)

(println (format-poly {:variable "x"
                        :coefficients [2 3 4]}))

(println (format-poly {:variable "x"
                       :coefficients [1 2 3 4]}))

(println (format-poly {:variable "x"
                       :coefficients [1 0 0 2 3 4]}))

(println (format-poly {:variable "x"
                       :coefficients [1 -2 3 -4 5 -6 7]}))