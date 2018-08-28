.PHONY: build, start, test
.SILENT: build, start, test

build:
	docker build -t emoji-ts .

start:
	docker run --name emoji-ts -it --rm -v ${shell pwd}/src:/opt/src emoji-ts npm start

test:
	docker run --name emoji-ts -it --rm -v ${shell pwd}/src:/opt/src -v ${shell pwd}/test:/opt/test emoji-ts npm test