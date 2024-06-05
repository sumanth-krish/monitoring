package com.example.springBootMonitoring;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.random;

@Component
public class service {
    private static int phoneOrderId = 0;
    private static int watchOrderId = 0;
    private Counter phoneCounter = null;
    private Counter watchCounter = null;
    private AtomicInteger activeUsers = null;

    public service(CompositeMeterRegistry meterRegistry) {
        phoneCounter = meterRegistry.counter("order.phone");
        watchCounter = meterRegistry.counter("order.watches");
        activeUsers = meterRegistry.gauge("number.of.active.users",new AtomicInteger(0));
        Random random = new Random();
        activeUsers.set(random.nextInt());
    }

    public Number fetchActiveUsers(){
        Random random = new Random();
        return 10*random();
    }

    public String orderPhone() {
        phoneOrderId += 1;
        phoneCounter.increment();
        return new String("Ordered Book with id = " + phoneOrderId);
    }

    public String orderWatch() {
        watchOrderId += 1;
        watchCounter.increment();
        return new String("Ordered Movie with id = " + watchOrderId);
    }
}
