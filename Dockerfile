FROM openjdk:17-alpine
COPY . /usr/src/myapp/
WORKDIR /usr/src/myapp/src
RUN javac TravellingSalesmanProblem.java
CMD ["java", "TravellingSalesmanProblem"]