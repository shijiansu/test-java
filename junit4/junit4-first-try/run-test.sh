#!/bin/bash

# surefire-report:report - will trigger mvn test;
# site -DgenerateReports=false - generate the css files to surefire-report, but not the full site
# a default maven skin library is at src/site/site.xml
./mvnw mvn clean surefire-report:report site -DgenerateReports=false
