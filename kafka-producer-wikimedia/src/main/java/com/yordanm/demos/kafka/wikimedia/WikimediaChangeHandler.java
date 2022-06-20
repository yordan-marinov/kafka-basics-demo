package com.yordanm.demos.kafka.wikimedia;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WikimediaChangeHandler implements EventHandler {

    private final KafkaProducer<String, String> kafkaProducer;
    private final String topic;
    private final Logger log = LoggerFactory.getLogger(WikimediaChangeHandler.class.getSimpleName());

    public WikimediaChangeHandler(KafkaProducer<String, String> kafkaProducer, String topic) {
        this.kafkaProducer = kafkaProducer;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {
        // no implementation need it in here
    }

    @Override
    public void onClosed() throws Exception {
        kafkaProducer.close();
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        log.info(messageEvent.getData());

        // Asynchronous
        String messageEventData = messageEvent.getData();
//        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, messageEventData);
        kafkaProducer.send(new ProducerRecord<>(topic, messageEventData));
    }

    @Override
    public void onComment(String s) throws Exception {
        // No implementation need in here
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("Error in Stream Reading", throwable);
    }
}
