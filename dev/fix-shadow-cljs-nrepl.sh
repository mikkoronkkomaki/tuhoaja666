#!/usr/bin/env bash

link_nrepl_port(){
	echo "Waiting for nREPL port"
	rm -f .nrepl-port
	until [ -f .shadow-cljs/nrepl.port ]
    do
      sleep 1
    done
      echo "Linking nREPL:n port"
      ln -s .shadow-cljs/nrepl.port .nrepl-port
  exit
}

npx shadow-cljs -A:dev watch app & (link_nrepl_port)

wait