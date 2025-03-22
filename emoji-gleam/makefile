.PHONY: build, start, test
.SILENT: build, start, test

build:
	docker build -t emoji-gleam .

start:
	docker run --name emoji-gleam -it --rm emoji-gleam love
