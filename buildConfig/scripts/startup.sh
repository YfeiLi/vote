#!/usr/bin/env bash

cd `dirname $0`
sudo nohup java -Xbootclasspath/a:./resources -jar vote-manager.jar spring &>> /data/logs/soar/vote-manager.log &
sleep 5s
tail -50 /data/logs/soar/vote-manager.log
