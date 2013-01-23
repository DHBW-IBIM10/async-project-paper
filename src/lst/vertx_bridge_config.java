HttpServer server = vertx.createHttpServer()
JsonObject bridgeConfig = new JsonObject().putString("prefix", "/eventbus");
        
JsonArray inboundPermitted = new JsonArray();
JsonArray outboundPermitted = new JsonArray();
        
// Let through messages for data synchronization
JsonObject addressData = new JsonObject().putString("address", "form.data");
inboundPermitted.add(addressData);

// Allow sending messages to all addresses that match this pattern
new JsonObject().putString("address_re", "form.data.client\\.\\d+")
outboundPermitted.add();

vertx.createSockJSServer(server).bridge(bridgeConfig, inboundPermitted,  outboundPermitted);