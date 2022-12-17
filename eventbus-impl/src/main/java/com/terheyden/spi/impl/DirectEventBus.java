package com.terheyden.spi.impl;

import java.util.ArrayList;
import java.util.List;

import com.terheyden.spi.api.EventBusProvider;

import io.vavr.CheckedConsumer;

/**
 * An event bus that sends events directly to listeners (no threading stuff).
 */
public class DirectEventBus implements EventBusProvider {

    private final List<CheckedConsumer<Object>> listeners = new ArrayList<>();

    @Override
    public void subscribe(CheckedConsumer<Object> listener) {
        listeners.add(listener);
    }

    @Override
    public void post(Object event) {
        listeners.forEach(listener -> listener.unchecked().accept(event));
    }
}
