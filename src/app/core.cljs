(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            ;; -- nav bar --
            [app.nav.events]
            [app.nav.views.nav :refer [nav]]
            [app.nav.subs]
            [app.theme :refer [cheffy-theme]]
            ["@smooth-ui/core-sc" :refer [Normalize ThemeProvider Button]]))

(defn app
  []
  [:<>
    [:> Normalize]
    [:> ThemeProvider {:theme cheffy-theme}
      [nav]
      [:> Button "Hello"]]])

(defn ^:dev/after-load start
  []
  (rf/dispatch [:initialize-db])
  (r/render [app]
    (.getElementById js/document "app")))

(defn ^:export init
  []
  (start))
