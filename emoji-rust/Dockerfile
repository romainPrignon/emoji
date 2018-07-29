FROM rust:1.27

WORKDIR /opt

COPY . .

RUN cd core && cargo install

# because cd core
CMD ["cargo", "run"]