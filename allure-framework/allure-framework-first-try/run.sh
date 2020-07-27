#!/bin/bash

./mvnw clean test
./mvnw allure:serve
