package qnd

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer

object Config {
    const val POLLING_CONSUMERS_COUNT  = 0;

    const val KAFKA_URL = "kafka.localhost:9092"
    const val TEST_TOPIC = "qnd"

    val keySerializerClassName: String = StringSerializer::class.java.name
    val valueSerializerClassName: String = StringSerializer::class.java.name

    val keyDeserializerClassName: String = StringDeserializer::class.java.name
    val valueDeserializerClassName: String = StringDeserializer::class.java.name
}