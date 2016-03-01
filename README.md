# every

execute a function at an interval

## Installation 

add to your project.clj dependencies

`[every "0.0.1"]`

## Usage

```clojure
(require '[every.core :refer (every)])

(defn do-somthing-awesome []
	(println "oh yes"))

;; you may specify
;; ms, s, m, h, d
(every "10s" do-somthing-awesome)

;; you may also specify a limit of total calls
(every "10s" do-somthing-awesome 20)
```

## License

Copyright © 2016 Brian Hurlow

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
