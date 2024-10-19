.PHONY: build, start, test
.SILENT: build, start, test

word ?= love

build:
	docker build -t emoji-coconut .

start: ## make start word=love
	docker run -it --rm --name emoji-coconut emoji-coconut ${word}

start-http:
	docker run --name emoji-coconut -it --rm -p 5000:5000 emoji-coconut uvicorn dist.http.main:app --host 0.0.0.0 --port 5000

test: ## TODO
	docker run --name emoji-coconut -it --rm -v ${shell pwd}/src:/opt/src -v ${shell pwd}/test:/opt/test emoji-coconut python -m unittest