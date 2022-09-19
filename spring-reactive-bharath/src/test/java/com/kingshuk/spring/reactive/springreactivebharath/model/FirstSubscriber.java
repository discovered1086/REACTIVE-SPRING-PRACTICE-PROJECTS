package com.kingshuk.spring.reactive.springreactivebharath.model;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstSubscriber implements Subscriber<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstSubscriber.class);

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(String s) {
        LOGGER.info("The record is {}", s);
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
