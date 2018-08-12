(defproject gamesdb-api "0.1.0-SNAPSHOT"
  :description "The API server for the gamesdb"
  :license {:name "Mozilla Public License 2.0"
            :url "https://www.mozilla.org/en-US/MPL/2.0/"}

  :plugins [[lein-ring "0.12.2"]]
  :ring {:handler gamesdb-api.core/handler}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [liberator "0.15.2"]
                 [compojure "1.6.0"]
                 [ring/ring-core "1.6.3"]
                 [org.postgresql/postgresql "42.2.4"]
                 [korma "0.4.3"]])
