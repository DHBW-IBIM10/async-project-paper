import org.vertx.java.deploy.Verticle;

public class CommandWorker extends Verticle {

    public void start() {
    	//TODO: listen for new tasks on the message bus
    }

    private void runCommand(String command, String workingDirectory, int timeoutInMs) {
    	Executor executor = new org.apache.commons.exec.DefaultExecutor();
    	//TODO: add code here :)
    }