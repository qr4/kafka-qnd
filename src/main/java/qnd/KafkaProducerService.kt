package qnd

import mu.KotlinLogging
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord

class KafkaProducerService {
    private val logger = KotlinLogging.logger {}
    private val producer: KafkaProducer<String, String>

    init {
        val config = mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to Config.KAFKA_URL,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to Config.keySerializerClassName,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to Config.valueSerializerClassName,
            ProducerConfig.CLIENT_ID_CONFIG to "qnd-producer"
        )

        producer = KafkaProducer(config)

        logger.info { "created producer service" }
    }

    fun sendMessageSynchronously(msg: String) {
        // TODO implement me
        // 1. create ProducerRecord with the topic Config.TEST_TOPIC, key (optional), message
        // 2. send it with producer.send
        // 3. resolve the future
    }

    fun sendMessageAsynchronously(msg: String) {
        // TODO implement me
        // 1. create ProducerRecord with the Config.TEST_TOPIC, key (optional), message
        // 2. send it with producer.send
    }
}