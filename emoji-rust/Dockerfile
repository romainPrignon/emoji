FROM rust:1.27

WORKDIR /opt

COPY . .

RUN cd core && cargo build

# here because of cd core
RUN cd core && cargo run

# comment because cd core
#CMD ["cargo", "run"]