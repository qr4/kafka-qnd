package qnd;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitali Henne (vitali.henne@freiheit.com).
 */
@RestController
public class Controller {
    private static final Logger LOG = LoggerFactory.getLogger( Controller.class );

    @Autowired
    KafkaProducerService kafkaService;

    @RequestMapping( method = RequestMethod.POST, value = "/sendMessage" )
    public void sendMessage( @RequestBody String message ) {
        LOG.info( "sending message to kafka: {}", message );
        kafkaService.sendMessageSynchronously( message );
    }

    @RequestMapping( method = RequestMethod.POST, value = "/sendMessages" )
    public void sendMessages() {
        LOG.info( "sending 100 messages asynchronously" );

        IntStream.range( 0, 100 ).forEach(
                i -> kafkaService.sendMessageAsynchronously( "message nr " + i )
        );
    }
}
