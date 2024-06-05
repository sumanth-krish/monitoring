package com.example.springBootMonitoring;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public MeterRegistry getMeterRegistry() {
        CompositeMeterRegistry meterRegistry = new CompositeMeterRegistry();
        return meterRegistry;
    }
}