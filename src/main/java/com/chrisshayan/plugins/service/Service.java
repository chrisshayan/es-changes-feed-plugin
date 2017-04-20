package com.chrisshayan.plugins.service;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.common.component.AbstractLifecycleComponent;
import org.elasticsearch.common.component.LifecycleListener;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.indices.IndicesService;


public class Service extends AbstractLifecycleComponent {

    private final Logger logger = Loggers.getLogger(Service.class);

    @Inject
    public Service(final Settings settings, IndicesService indicesService) {
        super(settings);
        logger.info("Service.Service");

        indicesService.addLifecycleListener(new LifecycleListener() {
            @Override
            public void afterStart() {
                logger.info("Service.afterStart");
            }
        });

        // TODO Your code..
    }

    @Override
    protected void doStart() throws ElasticsearchException {
        logger.info("Service.doStart");

        // TODO Your code..
    }

    @Override
    protected void doStop() throws ElasticsearchException {
        logger.info("Service.doStop");

        // TODO Your code..
    }

    @Override
    protected void doClose() throws ElasticsearchException {
        logger.info("Service.doClose");

        // TODO Your code..
    }

}
