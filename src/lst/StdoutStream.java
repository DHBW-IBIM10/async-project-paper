import java.util.LinkedList;
import java.util.List;
import org.apache.commons.exec.LogOutputStream;

public class StdoutStream extends LogOutputStream {
	@Override
	protected void processLine(String line, int level) {
		System.out.println(line);
	}
}