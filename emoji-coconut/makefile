.PHONY: build, start, test
.SILENT: build, start, test

word ?= love

build:
	docker build -t emoji-coconut .

start: ## make start word=love
	docker run -it --rm --name emoji-coconut emoji-coconut ${word}

start-cli: ## TODO
	docker run --name emoji-coconut -it --rm -v ${shell pwd}/src:/opt/src emoji-coconut python src/cli.py $(word)

start-http: ## TODO
	docker run --name emoji-coconut -it --rm -p 5000:5000 -v ${shell pwd}/src:/opt/src -e FLASK_ENV=development -e FLASK_APP=./src/http/main.py emoji-coconut flask run --host=0.0.0.0

test: ## TODO
	docker run --name emoji-coconut -it --rm -v ${shell pwd}/src:/opt/src -v ${shell pwd}/test:/opt/test emoji-coconut python -m unittest