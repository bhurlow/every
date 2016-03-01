(ns every.core
  (:gen-class))

(def umilli 1)
(def usecond (* 1000 umilli))
(def uminute (* 60 usecond))
(def uhour (* 60 uminute))
(def uday (* 24 uhour))

(def units
  {:ms umilli
   :s usecond
   :m uminute
   :h uhour
   :d uday})

(defn extract-amount [interval-string]
  (->> (map str interval-string)
       (filter (fn [char] (number? (read-string char)))) 
       (reduce str)
       (read-string)))

(defn extract-unit [interval-string]
  (->> (map str interval-string)
       (filter (fn [char] (not (number? (read-string char)))))
       (reduce str)
       (keyword)))

(defn parse-interval [interval-string]
  (if (number? interval-string) interval-string
    (let [amt (extract-amount interval-string)
          unit ((extract-unit interval-string) units)]
      (when (nil? unit) 
        (throw (Exception.  (str "invalid unit please use: " (keys units)))))
      (* amt unit))))

;; DODO make this not block
(defn every 
  ([interval-string f] (every interval-string f :forever))
  ( [interval-string f limit] 
    (let [interval (parse-interval interval-string)]
      (while true
        (f)
        (Thread/sleep interval)))))

