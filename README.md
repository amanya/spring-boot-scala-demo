# spring-boot-scala-demo

Translation to Scala of the Spring Getting Started tutorial [Building a RESTful WEB Service](https://spring.io/guides/gs/rest-service/)

## Usage

This project uses Gradle, so to run the service:

```
./gradlew bootRun
```

To run the test suite:

```
./gradlew test
```

To build the Docker container:

```
docker build -t spring-boot-scala-demo .
```

To run the Docker container:

```
docker run -it --rm -p 8080:8080 spring-boot-scala-demo
```
