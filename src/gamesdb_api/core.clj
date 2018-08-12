(ns gamesdb-api.core
  (:gen-class)
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.cors :refer [wrap-cors]]
            [compojure.core :refer [defroutes ANY GET]]
            [gamesdb-api.models :refer [get-all get-by-id]]))

(defresource root
  :available-media-types ["text/html"]
  :handle-ok "<html>Hello, Internet.</html>")

(defresource games
  :available-media-types ["application/json"]
  :handle-ok (fn [_] (get-all)))

(defresource game [id]
  :available-media-types ["application/json"]
  :handle-ok (fn [_] (get-by-id id)))

(defroutes app
  (ANY "/" [] root)
  (GET "/games" [] games)
  (GET "/games/:id" [id] (game id)))

(def handler
  (-> app
      wrap-params
      (wrap-cors #".*localhost.*")))
