package com.chrisshayan.plugins;

import com.chrisshayan.plugins.module.PluginModule;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.IndexModule;
import org.elasticsearch.index.IndexService;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.shard.IndexEventListener;
import org.elasticsearch.indices.cluster.IndicesClusterStateService;
import org.elasticsearch.plugins.Plugin;

import java.util.ArrayList;
import java.util.Collection;

public class ElasticSearchPlugin extends Plugin {
    private final Logger logger = Loggers.getLogger(ElasticSearchPlugin.class);

    @Override
    public Collection<Module> createGuiceModules() {
        Collection<Module> modules = new ArrayList<>(1);
        modules.add(new PluginModule());

        return modules;
    }

    @Override
    public void onIndexModule(IndexModule indexModule) {
        indexModule.addIndexEventListener(new IndexEventListener() {
            @Override
            public void afterIndexCreated(IndexService indexService) {
                logger.info("afterIndexCreated :" + indexService.getMetaData().getIndex().getName());
            }

            @Override
            public void afterIndexRemoved(Index index, IndexSettings indexSettings, IndicesClusterStateService.AllocatedIndices.IndexRemovalReason reason) {
                logger.info("afterIndexRemoved :" + index.getName());
            }
        });
    }
}
