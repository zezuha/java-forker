package forker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnceAMonthCleanup {

    private static Logger log = LoggerFactory.getLogger(OnceAMonthCleanup.class);

    public static void main(String[] args) {
        new OnceAMonthCleanup();
    }

    public OnceAMonthCleanup() {
        log.info(this.getClass().getName() + " started");
        run();
        log.info(this.getClass().getName() + " finished");
    }

    private void run() {
        Application.readFileContent(this.getClass().getName());
        Application.sleep(this.getClass().getName(), 10*1000);
    }

}
