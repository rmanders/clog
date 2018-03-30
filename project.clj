(defproject clog "1.0.0-SNAPSHOT"
  :description "A basic blog written in Clojure"
  :url "https://www.schlocknet.org/clog"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.6.0"]
                 [mount "0.1.12"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-defaults "0.3.1"]
                 [org.clojure/data.json "0.2.6"]
                 [org.dizitart/nitrite "2.1.1"]]
  :plugins [[lein-ring "0.12.4"]]
  :ring {:handler clog.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]
                        [com.novemberain/monger "3.1.0"]]}})
