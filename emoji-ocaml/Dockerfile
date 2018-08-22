FROM ocaml/opam:ubuntu

WORKDIR /opt

COPY . .

RUN opam build

CMD ["opam", "run"]