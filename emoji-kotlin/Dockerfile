FROM ubuntu:latest

WORKDIR /opt

RUN apt update && apt install -y \
    wget \
    unzip \
    openjdk-21-jdk

RUN wget -q -O /opt/kotlinc.zip https://github.com/JetBrains/kotlin/releases/download/v2.0.21/kotlin-compiler-2.0.21.zip
RUN unzip /opt/kotlinc.zip

# ---

COPY . .

RUN /opt/kotlinc/bin/kotlinc /opt/src/main.kt -include-runtime -d /opt/build/main.jar

ENTRYPOINT ["java", "-jar", "/opt/build/main.jar"]