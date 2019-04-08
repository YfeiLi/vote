#!/usr/bin/env bash

nohup java -Xbootclasspath/a:./resources -jar vote-manager.jar spring &>> /data/logs/soar/vote-manager.log &