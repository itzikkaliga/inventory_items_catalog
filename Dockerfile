FROM openjdk:8
COPY target/student-services-0.0.1-SNAPSHOT.jar student-services-0.0.1-SNAPSHOT.jar
EXPOSE 8083
CMD ["java", "-jar", "student-services-0.0.1-SNAPSHOT.jar"]