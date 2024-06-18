FROM jelastic/maven:3.9.4-openjdk-22.ea-b17

#RUN apt-get install maven
COPY . /app
WORKDIR /app
RUN ls -la 
CMD ["mvn", "spring-boot:run"]
