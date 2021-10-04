FROM kokalang/koka:v2.0.14

RUN apt update
RUN apt install -y node-amdefine node-requirejs

COPY . .

COPY std/ /usr/local/share/koka/v2.0.14/std/

# RUN koka -l std/encoding/json.kk --target js --host node desactiver tant que les generics ne marche pas

RUN koka -c src/main.kk --target js --host node
# RUN koka -c src/main.kk

# RUN ls -lah out/v2.0.14/js-debug/
# RUN cat out/v2.0.14/js-debug/std_encoding_json.js
# RUN cat out/v2.0.14/js-debug/src_core_main.js

# RUN ls -lah out/v2.0.14/gcc-debug
# RUN cat out/v2.0.14/gcc-debug/std_encoding_json.c
# RUN cat out/v2.0.14/gcc-debug/std_encoding_json.h
# RUN cat out/v2.0.14/gcc-debug/std_encoding_json.kki


RUN chmod a+x out/v2.0.14/js-debug/src_main.js
ENTRYPOINT ["node","out/v2.0.14/js-debug/src_main.js"]
# ENTRYPOINT ["out/v2.0.14/gcc-debug/src_main"]
