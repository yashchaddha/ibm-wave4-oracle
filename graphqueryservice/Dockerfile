FROM openjdk:11

ADD ./target/graphqueryservice-0.0.1-SNAPSHOT.jar /usr/src/graphqueryservice-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "graphqueryservice-0.0.1-SNAPSHOT.jar"]
