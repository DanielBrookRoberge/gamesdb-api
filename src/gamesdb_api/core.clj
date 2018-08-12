(ns gamesdb-api.core
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY GET]]
            [gamesdb-api.models :refer [get-all]]))

(defresource root
  :available-media-types ["text/html"]
  :handle-ok "<html>Hello, Internet.</html>")

(defresource games
  :available-media-types ["application/json"]
  :handle-ok (fn [_] (get-all)))

(defroutes app
  (ANY "/" [] root)
  (GET "/games" [] games))

(def handler
  (-> app
      wrap-params))
