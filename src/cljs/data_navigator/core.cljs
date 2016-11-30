(ns data-navigator.core
  (:require
   [reagent.core :as reagent]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Vars

(defonce debug?
  ^boolean js/goog.DEBUG)

(defonce app-state
  (reagent/atom
   {:text "Hello, what is your name? "}))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

#_(defn page [ratom]
  [:p (:text @ratom) "FIXME"])

(def left-bar-top-items ["APIs" "Data"])

(def left-bar-bottom-items ["About" "Settings"])

(defn page [ratom]
  [:p "dsafsf"]
  [:div {:id "left-bar"}
   [:div {:id "nav"}
    [:ul {:class "nav list-group"}
     (for [item left-bar-top-items]
       ^{:key item} [:li item])]
    [:ul {:class "nav bottom"}
     (for [item left-bar-bottom-items]
       ^{:key item} [:li item])]]])


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when debug?
    (enable-console-print!)
    (println "dev mode")
    ))

(defn reload []
  (reagent/render [page app-state]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))
