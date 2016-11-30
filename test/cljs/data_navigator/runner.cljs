(ns data-navigator.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [data-navigator.core-test]))

(doo-tests 'data-navigator.core-test)
