(ns clog.config.db
  (:require [mount.core :refer [defstate]])
  (:import (org.dizitart.no2 Nitrite)))


(defn db-create-nitrite []
  (-> (Nitrite/builder)
      (.compressed)
      (.filePath "./clog.no2.db")
      (.openOrCreate "blog-user" "changeme")))

(defstate conn :start (db-create-nitrite))

