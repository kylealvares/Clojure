(require '[clojure.string :as s])
(require '[clojure.pprint :refer [pprint]])
(require '[clojure.java.io :as io])

; (require '[city])

; (println "Question 1")

(defn strip-quotes [s]
    (s/replace s #"\"" "")
)

; (println (strip-quotes "hello"))
; (println (strip-quotes "\"world\""))

; (println "Question 2")

(defn parse-element [s]
    (try (Double/parseDouble s)
        (if (s/includes? s ".")
            (Double/parseDouble s)
            (Integer/parseInt s)
        )
       (catch Exception e (str s)) 
    )
)

; (println (let [x (parse-element "3.1415")]
;     [(type x) x]))

; (println (let [x (parse-element "3.")]
;     [(type x) x]))

; (println (let [x (parse-element "31415")]
;     [(type x) x]))

; (println (let [x (parse-element "hello world")]
;     [(type x) x]))

; (println "Question 3")

(defn parse-line [line]
    (for [x (clojure.string/split line #",")
        :let [y (parse-element (strip-quotes (s/trim  x)))]]
    y)
)

; (println (parse-line "\"hello\",\"world\""))
; (println (parse-line "hello,123,3.1415"))
; (println (parse-line "hello,   123   ,   3.1415   "))
; (println (parse-line "hello,  \" 123 \"  ,   \"3.1415\"   "))

; (println "Question 4")
; (require 'city)
(def city-file "canadacities.csv")
(defn reader [] (io/reader city-file))

(declare parse-line)
(defn load-header []
  (with-open [f (reader)]
    (-> (line-seq f)
        (nth 1)
        (parse-line))))
  
(defn load-rows []
  (with-open [f (reader)]
    (->> (line-seq f)
         (drop 2)
         (filter (complement s/blank?))
         (map parse-line)
         (into []))))

; (println "Question 5")
(defn build-hash-map [header row]
    (zipmap header row)
)

; (println "Question 6")
(defn abbreviate [city] 
    (hash-map :city (get city "city") :province_id (get city "province_id"))
)

; (println "Question 7")
(defn load-cities []
    (for [x (load-rows) :let [y (build-hash-map (load-header) x)]] y)
)

; (println "Question 8")
(defn load-abbreviated-cities [] 
    (for [x (load-cities) :let [y (abbreviate x)]] y)
)

; (println "Question 9")
(defn match? [pattern city]
    (let [split (clojure.string/split (str pattern) #" ")]
        (if (= (count split) 1)
            (clojure.string/includes? (str city) (first split))
            (if (clojure.string/includes? (first split) ":")
                (clojure.string/includes? (str (get city (subs (first split) 1))) (last split))
                (clojure.string/includes? (str (get city (first split))) (last split))
            )
        )
    )
)

; (println "Question 10")
(defn query [pattern cities]
    (for [x cities :let [y x] :when (match? pattern x)] y)
)