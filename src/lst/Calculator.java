public class Calculator extends Verticle {	
	/**
	 * Instantiates an insuranceForm and calculates the fee based on the forms data.
	 * The result is sent back via the event bus.
	 */
	private Handler<Message<JsonObject>> calculationHandler = new Handler<Message<JsonObject>>() {
		public void handle(Message<JsonObject> message) {
            InsuranceForm form = new InsuranceForm(message.body);
            JsonObject fee = new JsonObject();
            fee.putNumber("price", form.getInsuranceFee());
            message.reply(fee);
        }
    };

	@Override
	public void start() throws Exception {
		final EventBus eBus = vertx.eventBus();
        eBus.registerHandler("form.calculate", calculationHandler);
	}
}
