FROM rust:1.90-bullseye

WORKDIR /opt

COPY . .

RUN cargo build

# TODO: replace with bin
ENTRYPOINT ["/opt/target/debug/emoji"]