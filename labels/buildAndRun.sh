#!/bin/sh
mvn clean package && docker build -t com.airhacks/labels .
docker rm -f labels || true && docker run -d -p 8080:8080 -p 4848:4848 --name labels com.airhacks/labels 
