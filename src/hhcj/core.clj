(ns hhcj.core)

(defn fuzzy= [tor x y]
  (let [diff (Math/abs (- x y))]
    (< diff tor)))
