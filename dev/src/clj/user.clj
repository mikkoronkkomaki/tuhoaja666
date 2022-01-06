(ns shadow.user
  (:require [shadow.cljs.devtools.api :as shadow]))

(defn repl []
  (shadow/repl :app))
