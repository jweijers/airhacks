# Build
mvn clean package && docker build -t com.airhacks/music .

# RUN

docker rm -f music || true && docker run -d -p 8080:8080 -p 4848:4848 --name music com.airhacks/music 