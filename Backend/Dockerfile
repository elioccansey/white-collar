FROM openjdk:21
#EXPOSE 8080
ADD target/white-collar-0.0.1-SNAPSHOT.jar white-collar-service.jar
ENTRYPOINT [\
"java",\
 "-jar", \
 "/white-collar-service.jar"\
 ]