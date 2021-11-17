; LISTS

(def a (list "a" 1 :hello 3.14)) ; can be heterogenous

(def l (list 1 2 3 4 5 6 7)) ; uses linked list data structure

; seq - converts sequence into list
(println "\nseq - converts sequence to list")
(println "abcdef ->" (seq "abcdef"))
(println "[1 2 3 4] ->"(seq [1 2 3 4]))
(println "{:k1 :v1 :k2 :v2} ->" (seq {:k1 :v1 :k2 :v2}))

; range
(println "\nrange - range of numbers in list")
(println "(end) - [0 - end)")
(println "(start end) - [start - end)")
(println "(start end step) [start .. next .. end)")

; (range) - list from 0 - infinity
(println "10 ->" (range 10)) ; (0 1 2 3 4 5 6 7 8 9)
(println "-5 5 ->" (range -5 5)) ; (-5 -4 -3 -2 -1 0 1 2 3 4)
(println "0 10 2 ->" (range 0 10 2)) ; (0 2 4 6 8)
(println "(take 5 (range)) -> " (take 5 (range))) ; (0 1 2 3 4) sublist

(println "\nl =" l) 

; list functions
(println "first:" (first l)) ; returns first element in list
(println "last:" (last l)) ; returns last element in list
(println "l[3]:" (nth l 3)) ; returns nth element in list
(println "take 5:" (take 5 l)) ; sub-list from beginning
(println "take-last 5:" (take-last 5 l))
(println "drop 2:" (drop 2 l)) ; drops first 2 elements in list
(println "cons 0:" (cons 0 l)) ; prepend to list
(println "conj 0:" (conj l 0)) ; conj for list is a prepend to list
(println "concat [8 9]:" (concat l [8 9])) ; concatenates list
(println "into ():" (into () l)) ; prepends every element in list into ()
(println "count:" (count l)) ; length of a list
(println "sort:" (sort l)) ; sorts list
(println "reverse:" (reverse l)) ; reverses list