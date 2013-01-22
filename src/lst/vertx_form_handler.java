/**
 * Triggers the fee calculation based on the given form data.
 */
private Handler<HttpServerRequest> calcHandler = new Handler<HttpServerRequest>() {
	public void handle(final HttpServerRequest req) {
		// read body of request
		req.bodyHandler(new Handler<Buffer>() {
			@Override
			public void handle(Buffer buff) {
				JsonObject form = new JsonObject(buff.toString());
				// trigger calculation in worker verticle
				eBus.send("form.calculate", form,
				new Handler<Message<JsonObject>>() {
					public void handle(Message<JsonObject> message) {
						req.response.headers().put("Content-Type", "application/json; charset=utf-8");
						req.response.end(message.body.encode());
					}
				});
			}
		});
	}
};