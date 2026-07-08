import service.Logger;

/**
 * Demo: log messages at every level. Each call feeds the chain, and the
 * processor for that level prints it — the rest just pass it along.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.debug("starting up");
        logger.info("user logged in");
        logger.warn("low disk space");
        logger.error("null pointer exception!");
    }
}
