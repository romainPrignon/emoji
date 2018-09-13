.PHONY: build, start, test
.SILENT: build, start, test

build:
	docker build -t emoji-py .

start-cli: ## make start word=love
	docker run --name emoji-py -it --rm -v ${shell pwd}/src:/opt/src emoji-py python src/cli.py $(word)

start-http:
	docker run --name emoji-py -it --rm -p 5000:5000 -v ${shell pwd}/src:/opt/src -e FLASK_ENV=development -e FLASK_APP=./src/http/main.py emoji-py flask run --host=0.0.0.0

test:
	docker run --name emoji-py -it --rm -v ${shell pwd}/src:/opt/src -v ${shell pwd}/test:/opt/test emoji-py python -m unittest