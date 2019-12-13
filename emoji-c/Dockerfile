FROM gcc:9.2

WORKDIR /opt

COPY src/ /usr/src/emoji

# RUN install dependency ??

RUN gcc -std=c99 -Wall -O2 -lcurl -o /opt/main /usr/src/emoji/core/main.c

ENTRYPOINT ["/opt/main"]