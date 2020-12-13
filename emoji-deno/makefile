.PHONY: build start
.SILENT: build start

build:
	docker build -t emoji-deno .

start:
	docker run -it --rm --name emoji-deno emoji-deno love
