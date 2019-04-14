package forker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    private static final String USAGE = "Usage:\n"
            + "java -jar ./build/java-forker.jar <filename>\n";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println(USAGE);
            System.exit(1);
        }

        String fileName = args[0];
        Application app = new Application(fileName);
        app.run();
    }

    public Application(String fileName) {
    }
    
    private void run() {
    }

}
