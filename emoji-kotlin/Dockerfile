FROM ubuntu:latest

WORKDIR /opt

RUN apt update && apt install -y \
    wget \
    unzip \
    openjdk-21-jdk

RUN wget -q -O /opt/kotlinc.zip https://github.com/JetBrains/kotlin/releases/download/v2.0.21/kotlin-compiler-2.0.21.zip
RUN unzip /opt/kotlinc.zip

RUN wget -q -O /opt/kotlinx-coroutines-core-jvm-1.7.3.jar https://repo1.maven.org/maven2/org/jetbrains/kotlinx/kotlinx-coroutines-core-jvm/1.7.3/kotlinx-coroutines-core-jvm-1.7.3.jar
RUN wget -q -O /opt/kotlinx-serialization-json-jvm-1.6.3.jar https://repo1.maven.org/maven2/org/jetbrains/kotlinx/kotlinx-serialization-json-jvm/1.6.3/kotlinx-serialization-json-jvm-1.6.3.jar
RUN wget -q -O /opt/kotlinx-serialization-core-jvm-1.6.3.jar https://repo1.maven.org/maven2/org/jetbrains/kotlinx/kotlinx-serialization-core-jvm/1.6.3/kotlinx-serialization-core-jvm-1.6.3.jar
RUN wget -q -O /opt/kotlinx-serialization-compiler-plugin-2.0.21.jar https://repo1.maven.org/maven2/org/jetbrains/kotlin/kotlin-serialization-compiler-plugin/2.0.21/kotlin-serialization-compiler-plugin-2.0.21.jar

# ---

COPY . .

RUN /opt/kotlinc/bin/kotlinc /opt/src/*.kt -cp "/opt/kotlinx-coroutines-core-jvm-1.7.3.jar:/opt/kotlinx-serialization-json-jvm-1.6.3.jar:/opt/kotlinx-serialization-core-jvm-1.6.3.jar" -Xplugin=/opt/kotlinx-serialization-compiler-plugin-2.0.21.jar -include-runtime -d /opt/build/main.jar

# ENTRYPOINT ["java", "-jar", "/opt/build/main.jar"]
ENTRYPOINT ["java", "-cp", "/opt/build/main.jar:/opt/kotlinx-coroutines-core-jvm-1.7.3.jar:/opt/kotlinx-serialization-json-jvm-1.6.3.jar:/opt/kotlinx-serialization-core-jvm-1.6.3.jar", "emoji.MainKt"]