package com.chrisshayan.plugins;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.admin.cluster.node.info.NodeInfo;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.PluginInfo;
import org.elasticsearch.test.ESIntegTestCase;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.Matchers.is;

/**
 * Created by Chris Shayan on 4/20/17.
 *
 */
public class EsPluginTestCase extends ESIntegTestCase {
    private final Logger logger = Loggers.getLogger(EsPluginTestCase.class);


    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        return Collections.singleton(ElasticSearchPlugin.class);
    }

    public void testPluginIsLoaded() throws Exception {
        NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().setPlugins(true).get();
        for (NodeInfo nodeInfo : response.getNodes()) {
            boolean pluginFound = false;
            for (PluginInfo pluginInfo : nodeInfo.getPlugins().getPluginInfos()) {
                logger.info(pluginInfo.getName());
                if (pluginInfo.getName().equals(ElasticSearchPlugin.class.getName())) {
                    pluginFound = true;
                    break;
                }
            }
            assertThat(pluginFound, is(true));
        }
    }
}
