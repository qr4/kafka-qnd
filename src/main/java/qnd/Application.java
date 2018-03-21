package qnd;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Vitali Henne (vitali.henne@freiheit.com).
 */
@SpringBootApplication
public class Application {
    public static final int NUM_POLLING_CONSUMERS = 5;

    public static void main( final String[] args ) throws Exception {
        // create and start consumers
        IntStream.range( 0, NUM_POLLING_CONSUMERS ).boxed()
                .map( i -> new KafkaPollingConsumer() )
                .map( CompletableFuture::runAsync );

        SpringApplication.run( Application.class, args );
    }
}
