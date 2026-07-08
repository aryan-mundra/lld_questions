package processor;

import enums.LogLevel;

public class WarnProcessor extends LogProcessor {
    public WarnProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level == LogLevel.WARN) {
            System.out.println("[WARN]  " + message);
        } else {
            super.log(level, message);
        }
    }
}
