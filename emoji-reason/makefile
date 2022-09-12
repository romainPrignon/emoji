.PHONY: build start
.SILENT: build start

build:
	docker build -t emoji-reason .

start:
	docker run -it --rm --name emoji-reason emoji-reason love
