	private Handler<HttpServerRequest> formHandler = new Handler<HttpServerRequest>() {
		public void handle(final HttpServerRequest req) {
			req.bodyHandler(new Handler<Buffer>() {
				
				@Override
				public void handle(Buffer buff) {
					JsonArray form = new JsonArray(buff.toString());

					eBus.send("form.calculate", form,
							new Handler<Message<JsonArray>>() {
								public void handle(Message<JsonArray> message) {
									req.response.end(message.body.toString());
								}
							});
				}
			});
		}
	};