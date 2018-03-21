package qnd;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.stereotype.Service;

/**
 * @author Vitali Henne (vitali.henne@freiheit.com).
 */
@Service
public class KafkaProducerService {
    private static final String TOPIC = "qnd";

    final private KafkaProducer<String, String> producer;

    public KafkaProducerService() {
        final Properties props = new Properties();
        props.setProperty( ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092" );
        props.setProperty( ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer" );
        props.setProperty( ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer" );
        props.setProperty( ProducerConfig.ACKS_CONFIG, "all" ); // all replicas need to get the message for it to be accepted
        props.setProperty( ProducerConfig.RETRIES_CONFIG, "3" ); // retry 3 times if send failed
        props.setProperty( ProducerConfig.CLIENT_ID_CONFIG, "qnd-producer" );

        producer = new KafkaProducer<>( props );
    }

    public void sendMessageSynchronously( final String msg ) {
        // TODO implement me:
        // 1. create ProducerRecord with the TOPIC, key (optional), message
        // 2. send it with producer.send
        // 3. resolve the future
    }

    public void sendMessageAsynchronously( final String msg ) {
        // TODO implement me
        // 1. create ProducerRecord with the TOPIC, key (optional), message
        // 2. send it with producer.send
    }
}
