##
##
FROM eclipse-temurin:21-jdk

# Set author
LABEL Mentainer="jfcaraballo@gmail.com"

# Set the working directory
WORKDIR /application
COPY target/*.jar /application/news.jar

# Run the application
ENTRYPOINT ["java", "-jar", "news.jar"]