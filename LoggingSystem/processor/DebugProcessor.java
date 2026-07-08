package processor;

import enums.LogLevel;

public class DebugProcessor extends LogProcessor {
    public DebugProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level == LogLevel.DEBUG) {
            System.out.println("[DEBUG] " + message);
        } else {
            super.log(level, message); // not mine -> pass on
        }
    }
}
