package service;

import enums.LogLevel;
import processor.DebugProcessor;
import processor.ErrorProcessor;
import processor.InfoProcessor;
import processor.LogProcessor;
import processor.WarnProcessor;

/**
 * The facade callers use. It builds the chain of processors once, and exposes
 * friendly methods (debug/info/warn/error) that feed messages into the chain.
 * A message travels down the chain until the processor for its level handles it.
 */
public class Logger {
    private final LogProcessor chain;

    public Logger() {
        // DEBUG -> INFO -> WARN -> ERROR (each passes on what isn't its level)
        chain = new DebugProcessor(
                new InfoProcessor(
                new WarnProcessor(
                new ErrorProcessor(null))));
    }

    public void debug(String message) { chain.log(LogLevel.DEBUG, message); }
    public void info(String message)  { chain.log(LogLevel.INFO, message); }
    public void warn(String message)  { chain.log(LogLevel.WARN, message); }
    public void error(String message) { chain.log(LogLevel.ERROR, message); }
}
