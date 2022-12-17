package com.terheyden.spi.api;

import io.vavr.CheckedConsumer;

/**
 * Our Service Provider interface — we want to look for implementations of this.
 */
public interface EventBusProvider {

    /**
     * Register a listener.
     */
    void subscribe(CheckedConsumer<Object> listener);

    /**
     * Post an event.
     */
    void post(Object event);
}
