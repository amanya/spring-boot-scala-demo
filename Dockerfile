FROM adoptopenjdk/openjdk11:alpine-slim

LABEL maintainer="Albert Manya <albertmp@eml.cc>"

WORKDIR /app

ENV JAVA_HOME=/opt/jdk \
    PATH=/opt/jdk/bin:${PATH} \
    LANG=C.UTF-8

RUN apk upgrade --update && \
    apk add --update curl ca-certificates bash libstdc++ tzdata && \
    rm -rf /var/cache/apk/*

RUN ln -s /opt/java/openjdk /opt/jdk-11 && \
    ln -s /opt/jdk-11 /opt/jdk && \
    test -x /opt/jdk/bin/java

RUN curl -sSLo /usr/bin/dumb-init https://github.com/Yelp/dumb-init/releases/download/v1.2.2/dumb-init_1.2.2_amd64 && \
    chmod +x /usr/bin/dumb-init

RUN curl -sSLo /app/run-java.sh https://raw.githubusercontent.com/fabric8io-images/run-java-sh/master/fish-pepper/run-java-sh/fp-files/run-java.sh && \
    chmod +x /app/run-java.sh

ENV JAVA_APP_DIR /app

EXPOSE 8080

COPY build/libs/spring-boot-scala-demo-*.jar /app/spring-boot-scala-demo.jar
ENV JAVA_APP_JAR "spring-boot-scala-demo.jar"

ENTRYPOINT [ "/usr/bin/dumb-init", "--", "/app/run-java.sh" ]
