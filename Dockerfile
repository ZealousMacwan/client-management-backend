FROM eclipse-temurin:11
EXPOSE 8080
RUN mkdir /opt/app
COPY target/client-management-backend.jar /opt/app
CMD ["java", "-jar", "/opt/app/client-management-backend.jar"]