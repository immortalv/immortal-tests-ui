# automation-immortalv
 Immortalv automation tests

How to run?

docker pull selenium/standalone-chrome

docker run -d -p 4445:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome

docker build .
