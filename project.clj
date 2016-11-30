(defproject data-navigator "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [reagent "0.6.0"]
                 ;; [reagent-utils "0.2.0"]
                 [garden "1.3.2"]
                 ;; [cljsjs/react-bootstrap "0.30.6-0"]
                 [devcards "0.2.2" :exclusions [cljsjs/react]]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-garden "0.2.8"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"
                                    "test/js"
                                    "resources/public/css"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :garden {:builds [{:id           "screen"
                     :source-paths ["src/clj"]
                     :stylesheet   data-navigator.css/screen
                     :compiler     {:output-to     "resources/public/css/screen.css"
                                    :pretty-print? true}}]}

  
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.8.2"]
                   [figwheel-sidecar "0.5.8"]
                   [com.cemerick/piggieback "0.2.1"]]

    :plugins      [[lein-figwheel "0.5.8"]
                   [lein-doo "0.1.7"]
                   ;; [cider/cider-nrepl "0.13.0"]
                   ]
    :repl-options {; for nREPL dev you really need to limit output
                   :init (set! *print-length* 50)
                   :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
    }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {
                    ;; :on-jsload "data-navigator.core/reload"
                    :on-jsload "data-navigator.core/on-js-reload"
                    }
     :compiler     {:main                 data-navigator.core
                    :optimizations        :none
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/dev"
                    :asset-path           "js/compiled/dev"
                    :source-map-timestamp true}}

    {:id           "devcards"
     :source-paths ["src/devcards" "src/cljs"]
     :figwheel     {:devcards true}
     :compiler     {:main                 "data-navigator.core-card"
                    :optimizations        :none
                    :output-to            "resources/public/js/compiled/devcards.js"
                    :output-dir           "resources/public/js/compiled/devcards"
                    :asset-path           "js/compiled/devcards"
                    :source-map-timestamp true}}

    {:id           "hostedcards"
     :source-paths ["src/devcards" "src/cljs"]
     :compiler     {:main          "data-navigator.core-card"
                    :optimizations :advanced
                    :devcards      true
                    :output-to     "resources/public/js/compiled/devcards.js"
                    :output-dir    "resources/public/js/compiled/hostedcards"}}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            data-navigator.core
                    :optimizations   :advanced
                    :output-to       "resources/public/js/compiled/app.js"
                    :output-dir      "resources/public/js/compiled/min"
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}

    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:output-to     "resources/public/js/compiled/test.js"
                    :output-dir    "resources/public/js/compiled/test"
                    :main          data-navigator.runner
                    :optimizations :none}}
    ]})
