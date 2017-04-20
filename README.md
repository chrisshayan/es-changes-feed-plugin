# es-changes-feed-plugin
A sample code on ElasticSearch5 on how to attach a listener to an index.

ElasticSearch 5.x is pretty exciting release and it has many cool features. However this new release is very different than the older versions of ES, specially when it comes to plugin. Today, we needed to use a plugin called WebSocket Change Feed Plugin (by ForgeRock/Chris Clifton) and in ES5 documentations it was recommended as well.

Well we thought it has to be adaptable with ES5 however it is not compatible and perhaps ES did not updated their documentation. I'll try to upgrade the WebSocket plugin to ES5 and will share the results later too. In the meantime, I googled to see is there any guideline or documentation on how to build a ES5 plugin that you can attach a listener to an index lifecycle. For some reasons, I could not find any. Hence I spent few hours and finally I managed to make it work.

This is very simple code that shows how to do it.
