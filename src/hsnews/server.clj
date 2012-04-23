(ns hsnews.server
  (:require [noir.server :as server]
            [hsnews.db :as db]))

(server/load-views "src/hsnews/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (db/maybe-init)
    (server/start port {:mode mode
                        :ns 'hsnews})))