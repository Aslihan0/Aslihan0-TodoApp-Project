# Todo app project using Spring Boot in backend



- [x] Java 8
- [x] Spring Boot
- [x] Spring Data
- [x] H2 Database
- [x] Documented on Swagger
- [x] Maven
- [x] Dockerized and published on Docker Hub




## Test Application

You can run unit tests in `src/test/java/com/aslihan/todoapp`

## Run Application with dependencies on Maven

- For maven usage

```xml
$ mvn clean install
$ mvn spring-boot:run
```

#### PORT: 8080

Swagger UI will be run on this url

`http://localhost:8080/swagger-ui/index.html#`

### Docker Hub

You can pull this application from Docker Hub

Link: https://hub.docker.com/repository/docker/aslihan7/docker-project

`docker pull aslihan7/docker-project:tagname`

### Docker Build

`docker build --compress --force-rm -t {Docker_Hub_Username}/{Docker_Hub_RepoName}:{Tag} .`

Example: `  docker build . -t  aslihan7/docker-project:tagname
`

Run Docker image locally on a container with a name for the container.

` sudo docker run -dp 8080:8080 --name todoapp todoapp/asli
`
