(ns clog.handler
  (:use compojure.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.middleware.json :refer [wrap-json-body]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clog.handlers.bloghandlers :refer :all]
            [mount.core :as mount]))

(defroutes main-routes
           (GET "/" [] "<p>this is the main page</p>")
           (GET "/test" request ((test-handler request)))
           (GET "/api/info" request (info-handler))
           (GET "/api/blog/posts" [] "this returns a list of blog posts in order of date")
           (POST "/api/blog/posts" request "this saves a new blog post object")
           (route/not-found "Page not found"))

(def app
  (do (mount/start)
      (-> (handler/site main-routes))))