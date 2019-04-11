#!/usr/bin/env bash

cd `dirname $0`
sudo nohup java -Xbootclasspath/a:./resources -jar vote-manager.jar spring &>> /data/logs/soar/vote-manager.log &
tail -f /data/logs/soar/vote-manager.log
