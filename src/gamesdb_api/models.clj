(ns gamesdb-api.models
  (:require [korma.db :refer :all]
            [korma.core :refer :all]))

(defdb gamesdb
  (postgres :credentials))

(defentity game
  (pk :id)
  (entity-fields :title :platform :status :comment :active :computer))

(defn get-all []
  (select game (order :platform) (order :title)))
