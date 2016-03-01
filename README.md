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

(every "10s" do-somthing-awesome)
```

## License

Copyright © 2016 Brian Hurlow

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
