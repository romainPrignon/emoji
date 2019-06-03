FROM ocaml/opam:ubuntu

WORKDIR /opt

# prebuild
RUN opam build
RUN opam install dune

COPY . .

RUN dune build emoji-ocaml.exe

CMD ["_build/default/emoji-ocaml.exe"]
