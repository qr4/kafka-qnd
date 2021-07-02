package qnd;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vitali Henne (vitali.henne@freiheit.com).
 */
public class KafkaStreamsConsumer {
    private static final Logger LOG = LoggerFactory.getLogger( KafkaStreamsConsumer.class );
    private final String TOPIC = "qnd";
    private KafkaStreams kafkaStreams;

    public KafkaStreamsConsumer() {
        final Properties props = new Properties();
        props.setProperty( StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka.localhost:9092" );
        props.setProperty( StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName() );
        props.setProperty( StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName() );
        props.setProperty( StreamsConfig.APPLICATION_ID_CONFIG, "KafkaStreamsConsumer" );


        StreamsBuilder builder = new StreamsBuilder();
        builder.<String, String>stream(TOPIC).foreach(
                (k, v) -> {
                    LOG.info("key: " + k + ", value: " + v);
                }
        );

        builder.build();

        kafkaStreams = new KafkaStreams(builder.build(), props);
        // TODO implement me:
        // 1. create a StreamsBuilder
        // 2. stream from our TOPIC
        // 3. use forEach to print all messages
        // 4. create the KafkaStreams from the Builder and the props
    }

    void start() {
        if ( kafkaStreams != null ) {
            kafkaStreams.start();
            Runtime.getRuntime().addShutdownHook( new Thread( kafkaStreams::close ) );
        }
    }
}
