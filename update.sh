#!/bin/bash

set -e

git pull
mvn clean package
sh vote-manager/vote-manager-webapp/target/vote-manager-bin/vote-manager/restart.sh
sh vote-front/vote-front-webapp/target/vote-front-bin/vote-front/restart.sh
