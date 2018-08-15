build:
	docker build -t emoji-haskell .

start: 
	docker run -it --rm --name emoji-haskell emoji-haskell cabal run

exec:
	docker run -it --rm haskell:8 $(cmd)