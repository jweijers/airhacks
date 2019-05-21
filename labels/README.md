# Build
mvn clean package && docker build -t com.airhacks/labels .

# RUN

docker rm -f labels || true && docker run -d -p 8080:8080 -p 4848:4848 --name labels com.airhacks/labels 