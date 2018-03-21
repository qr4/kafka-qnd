# kafka-qnd
This is a small dummy project, illustrating how one can talk with kafka.

# Prerequisites:
* docker + docker-compose
* (optional) IDEA
* Java 8

# Usage:
* Add kafka.localhost to your /etc/hosts pointing to 127.0.0.1 (only for macOS users)
* Start the Zookeeper, Kafka, and Kafka manager with docker-compose up -d
* the kafka-manager is running on 0.0.0.0:9000
** You need to create the cluster yourself... the zookeeper url is `zookeeper:2181`
* Implement the missing features in the source code (marked with TODO)
* start your application with ./gradlew bootRun
