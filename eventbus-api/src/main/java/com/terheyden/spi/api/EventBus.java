package com.terheyden.spi.api;

import java.util.ServiceLoader;

import io.vavr.CheckedConsumer;

/**
 * The client will use this class to send events to the service provider.
 * This class isn't considered an implementation of {@link EventBusProvider}
 * because there's no META-INF file for it.
 */
public final class EventBus {

    private static final EventBusProvider EVENT_BUS;

    static {

        // Note that the loaded services are cached.
        // If we think the services might change, we can call ServiceLoader.reload().
        ServiceLoader<EventBusProvider> eventBusProviders = ServiceLoader.load(EventBusProvider.class);

        // Find and use the first implementation.
        // If none are found, just quietly use the NoopEventBus.
        EVENT_BUS = eventBusProviders
            .findFirst()
            .orElseGet(NoopEventBus::new);
    }

    public void subscribe(CheckedConsumer<Object> listener) {
        EVENT_BUS.subscribe(listener);
    }

    public void post(Object event) {
        EVENT_BUS.post(event);
    }
}
