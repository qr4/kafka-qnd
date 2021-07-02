package qnd;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vitali Henne (vitali.henne@freiheit.com).
 */
public class KafkaPollingConsumer implements Runnable {
    private static final String TOPIC = "qnd";
    private static final Logger LOG = LoggerFactory.getLogger( KafkaPollingConsumer.class );

    private final KafkaConsumer<String, String> kafkaConsumer;

    public KafkaPollingConsumer() {
        LOG.info( "creating consumer" );
        final Properties props = new Properties();
        props.setProperty( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka.localhost:9092" );
        props.setProperty( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName() );
        props.setProperty( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName() );
        props.setProperty( ConsumerConfig.GROUP_ID_CONFIG, "PollingConsumer" );

        // we want to commit our selves, this should result in a at-least-once consumer
        props.setProperty( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false" );

        kafkaConsumer = new KafkaConsumer<>( props );
    }

    @Override
    public void run() {
        ArrayList<String> topics = new ArrayList<>();
        topics.add(TOPIC);
        kafkaConsumer.subscribe(topics);
        while (true) {

            ConsumerRecords<String, String> results = kafkaConsumer.poll(-1);
            results.forEach((a -> {
                LOG.info("partition: " + a.partition() + ", data:" + a.value());
            }));

            kafkaConsumer.commitSync();
        }
        // TODO implement me
        // 1. Subscribe to TOPIC
        // 2. Poll from the TOPIC
        // 3. For each received ConsumerRecord print its partition and the value
        // 4. IMPORTANT!!!! after processing records, commit
    }
}
