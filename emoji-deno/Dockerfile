FROM hayd/deno:1.6.0

WORKDIR /opt
USER deno

COPY . .

RUN deno cache src/main.ts

ENTRYPOINT ["deno", "run", "-A", "/opt/src/main.ts"]