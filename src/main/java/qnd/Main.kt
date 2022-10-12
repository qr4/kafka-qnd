package qnd;

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import mu.KotlinLogging
import java.util.concurrent.CompletableFuture;

private val logger = KotlinLogging.logger {}

fun main() {
    val kafkaProducerService = KafkaProducerService()

    // create and start polling consumers
    val consumers = (0..Config.POLLING_CONSUMERS_COUNT).map {
        KafkaPollingConsumer()
    }.map {
        CompletableFuture.runAsync(it)
    }.toList()

    // create and start stream consumer
    KafkaStreamsConsumer().start();

    val server = embeddedServer(Netty, port = 8080) {
        routing {
            post("/sendMessage") {
                val message: String = call.receive()
                logger.info { "sending message to kafka: '$message'"}
                kafkaProducerService.sendMessageSynchronously( message )

                call.respond("OK")
            }

            post("/sendMessages") {
                logger.info { "sending 100 messages asynchronously" }
                for (i in 1 .. 100) {
                    kafkaProducerService.sendMessageAsynchronously("dummy message number $i")
                }
                call.respond("OK")
            }
        }
    }

    Runtime.getRuntime().addShutdownHook(Thread { server.stop() })

    server.start(wait = true)
}
