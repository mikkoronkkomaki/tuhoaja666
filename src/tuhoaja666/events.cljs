(ns tuhoaja666.events
  (:require
    [re-frame.core :as re-frame]))

(def default-db
  {:calculator {:current-value 0}})

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    default-db))
