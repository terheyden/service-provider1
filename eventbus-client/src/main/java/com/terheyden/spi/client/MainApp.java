package com.terheyden.spi.api;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Hello world.
 */
public final class MainApp {

    private static final Logger LOG = getLogger(MainApp.class);

    private MainApp() {
        // Private constructor since this shouldn't be instantiated.
    }

    public static void main(String... args) {

        EventBus eventBus = new EventBus();
        eventBus.subscribe(msg -> LOG.info("Got message: {}", msg));
        eventBus.post("Hello World!");
    }
}
