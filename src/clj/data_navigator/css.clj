(ns data-navigator.css
  (:require [garden.def :refer [defstyles]]))



(defstyles screen
  [
   ;; bootstrap-overrides
   [:body {:margin "0"}]
   [:.navbar-inverse :.navbar-inner
    {:background "linear-gradient(top, #333, #181818)"}]

   [:.navbar :.brand
    {:color "#fff"
     :font-weight "bold"
     :line-height "18px"
     :padding "8px auto auto"
     :margin-top "-2px"}]

   [:.navbar :.nav :.dropdown-toggle :.caret
    {:margin-top "27px"}]

   [:.navbar
    [:.nav
     [:>li
      [:>a
       {:padding-top "0"
        :padding-bottom "0"
        }]]]]

   [:.navbar
    [:.nav
     [:>li:last-child
      [:>a
       {:padding-right "0"}]]]]

   [:.fa-margin-right
    {:margin-right "0.5em"}]

   [:.fa-margin-left
    {:margin-left "0.5em"}]

   [:select
    {:margin-bottom "0"}]

   [:.dl-horizontal
    [:dt
     {:width "120px"}]]
   [:dd
    {:margin-left "140px"}]
   [:.table-help
    [:tr
     {:vertical-align "top"}]]

   [:.table-help
    [:th
     [:td
      {:border "0"}]]]

   [:.table-help
    [:th
     {:text-align "right"
      :margin "0"
      :padding-left "0"
      :white-space "nowrap"}]]

   [:.table [:td.wrapped
             {:word-break "break-all"}]]]


  ;; main
  [:html {:height "100%"}]
  [:body :div#app
   {:background-color "white"
    :min-height "100%"}]
  [:div#left-bar
    {
     :color "#eee"
     :background-color "#292B31"
     :height "100%"
     :width "80px"
     }])
