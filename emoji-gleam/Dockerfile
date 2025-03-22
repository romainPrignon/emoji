FROM ubuntu:latest

WORKDIR /opt

RUN apt update && apt install -y wget gnupg2 curl

# RUN wget https://packages.erlang-solutions.com/erlang-solutions_2.0_all.deb
# RUN dpkg -i erlang-solutions_2.0_all.deb
RUN apt update && apt install -y erlang rebar3 make

RUN wget -q -O gleam.tar.gz https://github.com/gleam-lang/gleam/releases/download/v1.5.1/gleam-v1.5.1-x86_64-unknown-linux-musl.tar.gz

RUN tar -xvf gleam.tar.gz

# RUN curl -sL https://deb.nodesource.com/setup_22.x -o /tmp/nodesource_setup.sh
# RUN bash /tmp/nodesource_setup.sh
# RUN apt install -y nodejs

# ---

COPY gleam.toml gleam.toml
RUN /opt/gleam deps download

COPY . .
# RUN /opt/gleam build


ENTRYPOINT ["/opt/gleam", "run"]