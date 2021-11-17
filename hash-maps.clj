; HASH-MAPS

(def a (hash-map "a" 1 :b 2.1)) ; hash-maps can be heterogenous

(def h (hash-map :k1 "v1" :k2 "v2" :k3 {:l1 "v3" :l2 {:m1 "v4"}})) ; key-value pairs are stored

(def map-keys [:a :b :c])
(def map-vals [1 2 3])
(println "map-keys:" map-keys)
(println "map-vals:" map-vals)

; zipmap - makes map from keys and values
(println "zipmap:" (zipmap map-keys map-vals)) 

(println "\nh =" h)

; hash-map functions
(println "keys:" (keys h)) ; keys of a hash-map
(println "vals:" (vals h)) ; values of a hash-map
(println "get :k1:" (get h :k1)) ; returns value of key (or nil)
(println "get-in [:k3 :l2 :m1]:" (get-in h [:k3 :l2 :m1])) ; returns value in nested hash-map
(println "contains? :k2:" (contains? h :k2))
(println "assoc :k1 1 :k4 2:" (assoc h :k1 1 :k4 2)) ; updates / overwrites old hash-map
(println "assoc-in:" (assoc-in h [:k3 :l1] "v5")) ; updates / overwrites hash-map (used for nested)
(println "dissoc :k3:" (dissoc h :k3)) ; removes key-value pair from hash-map
(println "{:a 1} -> update inc:" (update {:a 1} :a inc)) ; updated value with function
(println "[{:a 1} {:a 2}] -> update-in [1 :a] + 10" (update-in [{:a 1} {:a 2}] [1 :a] + 10))
(println "merge {:a 1} {:b 2} ->" (merge {:a 1} {:b 2})) ; merges hashmaps
; merges and applies function to values with same keys
(println "merge-with + {:a 1} {:a 9  :b 98} ->" (merge-with + {:a 1} {:a 9  :b 98})) 
(println "into (sorted-map) [[:a 1] [:b 2]] ->" (into (sorted-map) [ [:a 1] [:b 2]]))
