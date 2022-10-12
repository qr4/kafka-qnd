package qnd

import mu.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration

class KafkaPollingConsumer : Runnable {
    private val logger = KotlinLogging.logger {}
    private val kafkaConsumer: KafkaConsumer<String, String>

    init {
        val config = mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to Config.KAFKA_URL,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to Config.keyDeserializerClassName,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to Config.valueDeserializerClassName,
            ConsumerConfig.GROUP_ID_CONFIG to "PollingConsumer",

            // we want to commit ourselves, this should result in an at-least-once consumer
            ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG to "false"
        )

        kafkaConsumer = KafkaConsumer(config)
        logger.info { "created polling consumer" }
    }

    override fun run() {
        // TODO implement me
        // 1. Subscribe to Config.TEST_TOPIC
        // 2. Poll in a loop
        // 3. For each received ConsumerRecord print its partition and the value
        // 4. IMPORTANT!!!! after processing records, commit
    }
}