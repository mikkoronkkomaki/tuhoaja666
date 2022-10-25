# Tuhoaja 666

A simple [Re-Frame](https://github.com/day8/re-frame) demo app.

## 

### Environment Setup

1. Install [JDK 8 or later](https://openjdk.java.net/install/) (Java Development Kit)
2. Install [Node.js](https://nodejs.org/) (JavaScript runtime environment) which should include
   [NPM](https://docs.npmjs.com/cli/npm) or if your Node.js installation does not include NPM also install it.
5. Clone this repo and open a terminal in the `tuhoaja666` project root directory

### Quickstart
```sh
npm install
npm run dev
```
or if the deps bite you in the rear 
```
npm install --legacy-peer-deps
npm run dev
```

When `[:app] Build completed` appears in the output, browse to
[http://localhost:8280/](http://localhost:8280/).

Open [http://localhost:8290/](http://localhost:8290/) for the test runner.

## Tools used

### [ClojureScript](https://clojurescript.org/)

ClojureScript is basically a compiler for compiling Clojure into JavaScript. Uses Google Closure for optimization.

### [Leiningen](https://leiningen.org/)

Tool for Clojure project management. In this case used only for creating the project using a template [Re-Frame -template project](https://github.com/day8/re-frame-template).
A rather nifty way to get a working project template straight out of the box.


### [Clojure-CLI (deps.edn)](https://clojure.org/guides/deps_and_cli)
                                                                             
ClojureScript libraries and dependencies are handled using deps.edn in this project.

### [Shadow-CLJS](https://github.com/thheller/shadow-cljs)

ClojureScript compiler used in this project. Handles integration with NPM, live reload, REPL etc.

### [Reagent](https://github.com/reagent-project/reagent)

Simple interface for ClojureScript to Reactiin. Enables writing React-components using ClojureScript functions. Instead of the Reacts "not quite HTML" uses Hiccup which is representated via Clojure basic datastructures (maps and vectors).

### [Re-Frame](https://github.com/day8/re-frame)

ClojureScript frontend framework. "Last in the chain", meaning it builds on Reagent and enables building React components. Alters the React basic paradigm a bit. Basically Re-Frame events are the only means for mutating the app state and views react to them via subscriptions.

#### Basic concepts

1. App state (db)
   1. "Big atom" = all state stored in one place
2. Views
   1. React components done using Hiccup
3. Subscriptions
   1. For getting the app state
4. Events
   1. For mutating the app state

### [Stylefy](https://github.com/Jarzka/stylefy)
CLJS-library made by Jari Hanhela, which enables writing CSS styles as Clojure data and attaching them to Reagent components.

### [Velho DS](https://github.com/velho-allianssi/velho-ds)
Reagent component library developed by the Velho alliance.
