package forker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

//    private static final String USAGE = "Usage:\n"
//            + "java -jar ./build/java-forker.jar <filename>\n";

    public static void main(String[] args) {
//        if (args.length < 1) {
//            System.err.println(USAGE);
//            System.exit(1);
//        }

//        String fileName = args[0];
        Application app = new Application();
        app.run();
    }

    private static final String FILENAME = "content.txt";

    public Application() {
        log.info("Application started");
        // forking
        try {
            JavaProcess.exec(OnceAMonthCleanup.class);
        } catch (IOException | InterruptedException problem) {
            log.error(OnceAMonthCleanup.class.getName() + " failed " + problem.getMessage());
        }
        run();
        log.info("Application finished");
    }

    private void run() {
        readFileContent(this.getClass().getName());
        sleep(this.getClass().getName(), 15*1000);
    }

    static void sleep(final String processName, int ms) {
        log.info(processName + " is running for " + ms/1000 + " seconds");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignore) {
        }
    }

    static void readFileContent(final String processName) {
        BufferedReader br = null;
        try {
            File file = new File(FILENAME);
            br = new BufferedReader(new FileReader(file)); 
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println("file " + FILENAME + " content: " + st);
            }
        } catch (IOException problem) {
            log.error(processName + " was unable to read content of " + FILENAME);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ignore) {
                }
            }
        }
        log.info(processName + " successfully read "+ FILENAME);
    }
}
