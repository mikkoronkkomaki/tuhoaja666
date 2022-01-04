(ns tuhoaja666.events
  (:require
   [re-frame.core :as re-frame]
   [tuhoaja666.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
