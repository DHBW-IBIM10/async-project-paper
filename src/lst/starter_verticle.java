package main;
import org.vertx.java.core.SimpleHandler;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.deploy.Verticle;

public class AppStarter extends Verticle {
	private static final String HTTP_CONF = "http_conf";
	private static final int NUM_PROCESSORS = Runtime.getRuntime().availableProcessors();

	@Override
	public void start() throws Exception {
		JsonObject httpConfig = appConfig.getObject(HTTP_CONF);
		container.deployVerticle("main.Server", httpConfig);
		container.deployWorkerVerticle("form.Calculator", NUM_PROCESSORS - 1);
	}
}