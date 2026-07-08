package processor;

import enums.LogLevel;

public class ErrorProcessor extends LogProcessor {
    public ErrorProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level == LogLevel.ERROR) {
            System.out.println("[ERROR] " + message);
        } else {
            super.log(level, message);
        }
    }
}
