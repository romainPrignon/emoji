build:
	docker build --no-cache -t emoji-ocaml .

start: 
	docker run -it --rm -v ${shell pwd}/src:/opt/src --name emoji-ocaml emoji-ocaml
