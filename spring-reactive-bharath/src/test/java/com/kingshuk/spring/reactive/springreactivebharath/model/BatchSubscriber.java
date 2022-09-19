package com.kingshuk.spring.reactive.springreactivebharath.model;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchSubscriber implements Subscriber<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchSubscriber.class);

    private long count = 0;
    private Subscription subscription;

    private final long batchSize = 2;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(batchSize);
    }

    @Override
    public void onNext(String s) {
        LOGGER.info("The record is {}", s);
        count++;
        if (count >= batchSize) {
            subscription.request(batchSize);
        }
    }

    @Override
    public void onError(Throwable t) {
        LOGGER.error("An error occurred while processing an element", t);
    }

    @Override
    public void onComplete() {
        LOGGER.info("The processing of the records have been completed");
    }
}
