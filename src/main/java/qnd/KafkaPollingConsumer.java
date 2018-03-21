package qnd;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @author Vitali Henne (vitali.henne@freiheit.com).
 */
public class KafkaPollingConsumer implements Runnable {
    private static final String TOPIC = "qnd";
    private final KafkaConsumer<String, String> kafkaConsumer;

    public KafkaPollingConsumer( ) {
        final Properties props = new Properties();
        props.setProperty( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092" );
        props.setProperty( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer" );
        props.setProperty( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer" );
        props.setProperty( ConsumerConfig.GROUP_ID_CONFIG, "PollingConsumer" );

        // we want to commit our selves, this should result in a at-least-once consumer
        props.setProperty( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false" );

        kafkaConsumer = new KafkaConsumer<>( props );
    }

    @Override
    public void run() {
        // 1. Poll from the TOPIC
        // 2. For each received ConsumerRecord print its partition and the value
        // 3. after processing a record commit
    }
}
