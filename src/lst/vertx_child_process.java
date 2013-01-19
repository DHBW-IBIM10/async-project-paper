import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.deploy.Verticle;

public class CommandExecutor extends Verticle {
	Logger logger = container.getLogger();

	@Override
	public void start(){
		final EventBus eBus = vertx.eventBus();

        eBus.registerHandler("cmd.execute", new Handler<Message<JsonObject>>() {

			public void handle(Message<JsonObject> message) {
				CommandLine cmdLine = new CommandLine("ls");
				cmdLine.addArgument("-lh");
				cmdLine.addArgument("/usr");
				//timeout after 6 seconds
				ExecuteWatchdog watchdog = new ExecuteWatchdog(60*1000); 
				DefaultExecutor executor = new DefaultExecutor();
				executor.setWatchdog(watchdog);
				try {
					executor.execute(cmdLine);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
	}
}