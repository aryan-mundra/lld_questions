package processor;

import enums.LogLevel;

public class InfoProcessor extends LogProcessor {
    public InfoProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level == LogLevel.INFO) {
            System.out.println("[INFO]  " + message);
        } else {
            super.log(level, message);
        }
    }
}
