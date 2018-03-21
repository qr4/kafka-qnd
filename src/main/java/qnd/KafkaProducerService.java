package qnd;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Vitali Henne (vitali.henne@freiheit.com).
 */
@Service
public class KafkaProducerService {
    private static final String TOPIC = "qnd";
    private static final Logger LOG = LoggerFactory.getLogger( KafkaProducerService.class );

    final private KafkaProducer<String, String> producer;

    public KafkaProducerService() {
        final Properties props = new Properties();
        props.setProperty( ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092" );
        props.setProperty( ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName() );
        props.setProperty( ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName() );
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
