(ns gamesdb-api.models
  (:require [korma.db :refer :all]
            [korma.core :refer :all]))

(defdb gamesdb
  (postgres {:connection-uri (System/getenv "JDBC_DATABASE_URL")}))

(defentity game
  (pk :id)
  (entity-fields :title :platform :status :comment :active :computer))

(defn get-all []
  (select game (order :platform) (order :title)))

(defn get-by-id [id]
  (select game (where {:id (Integer/parseInt id)})))
