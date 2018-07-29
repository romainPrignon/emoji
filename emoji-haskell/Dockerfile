FROM haskell:8

WORKDIR /opt

COPY . .

RUN cabal update
RUN cabal install

CMD ["cabal", "run"]