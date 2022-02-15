FROM openjdk:8u191-jre-alpine3.8

# WORKSPACE
WORKDIR /usr/share/udemy

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

#BROWSER
#HUB_HOST
#SUITE_MODULE
# All of these are parameterized and sent in the docker run command
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/\* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $SUITE_MODULE



