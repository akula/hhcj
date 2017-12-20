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

(send-request "www.baidu.com"  80 "/index.html")


