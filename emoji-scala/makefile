.PHONY: build, start, test
.SILENT: build, start, test

build:
	docker build -t emoji-scala .

start:
	docker run --name emoji-scala -it --rm -v ${shell pwd}/src:/opt/src emoji-scala sbt run

test:
	docker run --name emoji-scala -it --rm -v ${shell pwd}/src:/opt/src -v ${shell pwd}/test:/opt/test emoji-scala sbt test