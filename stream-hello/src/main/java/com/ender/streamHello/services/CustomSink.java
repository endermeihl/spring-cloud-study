package com.ender.streamHello.services;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface CustomSink extends Sink {

    String INPUT = "input";


    @Input(INPUT)
    SubscribableChannel input();


}