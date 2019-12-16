FROM gcc:9.2

WORKDIR /opt

COPY src/ /usr/src/emoji/src
COPY lib/ /usr/src/emoji/lib

RUN g++ -std=c++1z -I /usr/src/emoji/lib -Wall -o /opt/main /usr/src/emoji/src/main.cpp

ENTRYPOINT ["/opt/main"]