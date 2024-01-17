# Human Resources (Microservice architecture)
A microservice focused on the Human Resources sector, made with Spring Framework - Jan 2024

#
###### 🐋 Docker - New docker network to human resources microservice
```
docker network create hr-net
```

###### 🐋 Docker - Testing dev profile w. PostgreSQL on Docker
```
docker pull postgres:12-alpine

docker run -p 5432:5432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker postgres:12-alpine

docker run -p 5432:5432 --name hr-user-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_user postgres:12-alpine
```

###### 🐋 Docker - hr-config-server infrastructure
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]
``` 
```
mvnw clean package

docker build -t hr-config-server:v1 .

docker run -p 8888:8888 --name hr-config-server --network hr-net -e GITHUB_USER=acenelio -e GITHUB_PASS= hr-config-server:v1
```

###### 🐋 Docker - hr-eureka-server infrastructure
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
ENTRYPOINT ["java","-jar","/hr-eureka-server.jar"]
``` 
```
mvnw clean package

docker build -t hr-eureka-server:v1 .

docker run -p 8761:8761 --name hr-eureka-server --network hr-net hr-eureka-server:v1
```

###### 🐋 Docker - hr-worker infrastructure
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-worker-0.0.1-SNAPSHOT.jar hr-worker.jar
ENTRYPOINT ["java","-jar","/hr-worker.jar"]
``` 
```
mvnw clean package -DskipTests

docker build -t hr-worker:v1 .

docker run -P --network hr-net hr-worker:v1
```

###### 🐋 Docker - hr-user infrastructure
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-user-0.0.1-SNAPSHOT.jar hr-user.jar
ENTRYPOINT ["java","-jar","/hr-user.jar"]
``` 
```
mvnw clean package -DskipTests

docker build -t hr-user:v1 .

docker run -P --network hr-net hr-user:v1
```

###### 🐋 Docker - hr-payroll infrastructure
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-payroll-0.0.1-SNAPSHOT.jar hr-payroll.jar
ENTRYPOINT ["java","-jar","/hr-payroll.jar"]
``` 
```
mvnw clean package -DskipTests

docker build -t hr-payroll:v1 .

docker run -P --network hr-net hr-payroll:v1
```

###### 🐋 Docker - hr-oauth infrastructure
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-oauth-0.0.1-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","/hr-oauth.jar"]
``` 
```
mvnw clean package -DskipTests

docker build -t hr-oauth:v1 .

docker run -P --network hr-net hr-oauth:v1
```

###### 🐋 Docker - hr-api-gateway (ZUUL) infrastructure
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/hr-api-gateway-zuul-0.0.1-SNAPSHOT.jar hr-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]
``` 
```
mvnw clean package -DskipTests

docker build -t hr-api-gateway-zuul:v1 .

docker run -p 8765:8765 --name hr-api-gateway-zuul --network hr-net hr-api-gateway-zuul:v1
```

###### 🐋 Docker - Some Commands
Create a new docker network
```
docker network create <nome-da-rede>
```
Download image from Dockerhub
```
docker pull <nome-da-imagem:tag>
```
Show all imagens
```
docker images
```
Create/run a docker image container
```
docker run -p <porta-externa>:<porta-interna> --name <nome-do-container> --network <nome-da-rede> <nome-da-imagem:tag> 
```
Show all containers
```
docker ps

docker ps -a
```
Track docker container logs at runtime
```
docker logs -f <container-id>
```