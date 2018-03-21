# kafka-qnd
This is a small dummy project, illustrating how one can talk with kafka.

# Prerequisites:
* docker + docker-compose
* Java 8

# Usage:
* Add kafka to your /etc/hosts pointing to 127.0.0.1
* Start the Zookeeper, Kafka, and Kafka manager with docker-compose up -d
* the kafka-manager is running on 0.0.0.0:9000
* Implement the missing features in the source code (marked with TODO)
* start your application with ./gradlew bootRun
