.PHONY: build, start, test
.SILENT: build, start, test

build:
	docker build -t emoji-php .

start:
	docker run --name emoji-php -it --rm -v ${shell pwd}/src:/opt/src emoji-php php src/main.php love

test:
	docker run --name emoji-php -it --rm -v ${shell pwd}/src:/opt/src -v ${shell pwd}/test:/opt/test emoji-php composer run test