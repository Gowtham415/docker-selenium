FROM openjdk:8u191-jre-alpine3.8

# WORKSPACE
WORKDIR /usr/share/udemy

RUN apk add curl jq

# Add .jar under target to this host
# into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# in case of any other dependencies like .csv, .xlsx, .sql
# please add them as well

# Add testng suite files
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml

# Add Healthcheck script
ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh



