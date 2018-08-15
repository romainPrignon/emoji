FROM haskell:8

WORKDIR /opt

COPY . .

RUN cd core && cabal update
RUN cd core && cabal install

CMD ["cabal", "run"]