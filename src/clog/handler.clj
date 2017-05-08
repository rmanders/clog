(ns clog.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def route-get-user-posts [userId]
  (str "All posts for user: " userId))

(defroutes app-routes
  (GET "/" [] "Display all public posts for all users")
  (GET "/user/:userId/posts/:postId" [] "Specific Post Page")
  (POST "/user/:userId/posts/" [] "Post a new entry here")
  (GET "/user/:userId/posts/" [] "Gets all posts for a given user")
  (DELETE "/user/:userId/posts/:postId" [] "Delete a specific post")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
