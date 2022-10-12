package qnd

import mu.KotlinLogging
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import java.util.*

class KafkaStreamsConsumer {
    private val logger = KotlinLogging.logger {}
    private var kafkaStreams: KafkaStreams? = null

    init {
        val props = Properties()
        props.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, Config.KAFKA_URL)
        props.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String()::class.java.name)
        props.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String()::class.java.name)
        props.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "KafkaStreamsConsumer")

        // TODO implement me
        // 1. create a StreamsBuilder
        // 2. stream from Config.TEST_TOPIC
        // 3. use forEach to print all messages
        // 4. create the KafkaStreams from the StreamsBuilder and the props

        logger.info { "created streaming consumer" }
    }

    fun start() {
        kafkaStreams?.let {
           it.start()
            Runtime.getRuntime().addShutdownHook(Thread { it.close() })
        }
    }
}