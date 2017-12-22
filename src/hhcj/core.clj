(ns hhcj.core
  (:require [clojure.java.io :as io]))

(require '[clojure.java.io :as io])
(import '[java.io StringWriter]
        '[java.net Socket])

(defn send-request
  "send a http get request to the specified host, port and path."
  [host port path]
  (with-open [sock (Socket. host port)
              writer (io/writer sock)
              reader (io/reader sock)
              response (StringWriter.)]
    (.append writer (str "GET " path "\n"))
    (.flush writer)
    (io/copy reader response)
    (str response)))

(def a-z (vec (map char (range 97 123))))
(def A-Z (vec (map char (range 65 91))))
(def digests (vec (map char (range 48 58))))

(reduce into [digests a-z A-Z])
(defn rand-str
  [n]
  (apply str (repeatedly n #(.charAt "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" (rand-int 36)))))

