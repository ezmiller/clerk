(ns user
  (:require [nextjournal.beholder :as beholder]
            [nextjournal.clerk :as clerk :refer [show!]]
            [nextjournal.clerk.view]
            [nextjournal.clerk.webserver :as webserver]))

(defn go []
  (def watcher
    (beholder/watch #(clerk/file-event %) "notebooks" "src"))

  (webserver/start! {}))

(defn toggle-dev! []
  (alter-var-root #'nextjournal.clerk.view/live-js? not))

(comment
  (go)

  (toggle-dev!)

  (beholder/stop watcher)


  (show! "notebooks/elements.clj")
  (show! "notebooks/rule_30.clj")
  (show! "notebooks/onwards.clj")
  (show! "notebooks/how_clerk_works.clj")
  (show! "notebooks/pagination.clj")

  (show! "notebooks/viewers/vega.clj")
  (show! "notebooks/viewers/plotly.clj")
  (show! "notebooks/viewers/tex.clj")
  (show! "notebooks/viewers/markdown.clj")
  (show! "notebooks/viewers/html.clj")

  (clerk/clear-cache!)

  )