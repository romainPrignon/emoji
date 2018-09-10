.PHONY: build, start, test
.SILENT: build, start, test

build:
	docker build -t emoji-py .

start: ## make start cmd=cli word=love
	docker run --name emoji-py -it --rm -v ${shell pwd}/src:/opt/src emoji-py python src/$(cmd).py $(word)

test:
	docker run --name emoji-py -it --rm -v ${shell pwd}/src:/opt/src -v ${shell pwd}/test:/opt/test emoji-py pip run test