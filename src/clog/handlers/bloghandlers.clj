(ns clog.handlers.bloghandlers
  (:require [clojure.data.json :as json])
  (:require [clog.config.db :refer [conn]]))

(defn test-handler [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (str request)})

(defn info-handler []
  {:headers {"Content-Type" "application/json"}
   :body (json/write-str {:appName "<application name>"
                          :fleet "<application fleet>"
                          :version (System/getProperty "projectname.version")
                          :build-date "<build date>"})
   })

(defn blog-post-handler [post]
  (str post))