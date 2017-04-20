package com.chrisshayan.plugins.module;

import com.chrisshayan.plugins.service.Service;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.logging.Loggers;

public class PluginModule extends AbstractModule {
    private final Logger logger = Loggers.getLogger(PluginModule.class);

    @Override
    protected void configure() {
        logger.info("Binding Changes Feed Plugin");
        bind(Service.class).asEagerSingleton();
    }

}
