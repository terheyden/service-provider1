package com.terheyden.spi.api;

import io.vavr.CheckedConsumer;

/**
 * NoopEventBus class in case we can't find an implementation.
 */
public class NoopEventBus implements EventBusProvider {

    @Override
    public void subscribe(CheckedConsumer<Object> listener) {
        // noop
    }

    @Override
    public void post(Object event) {
        // noop
    }
}
