FROM hseeberger/scala-sbt

WORKDIR /opt

COPY build.sbt build.sbt

RUN sbt update

CMD ["sbt", "run"]