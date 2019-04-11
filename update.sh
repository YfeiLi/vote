#!/bin/bash

set -e

git pull
mvn clean package
sh vote-manager/vote-manager-webapp/target/vote-manager-bin/vote-manager/startup.sh
