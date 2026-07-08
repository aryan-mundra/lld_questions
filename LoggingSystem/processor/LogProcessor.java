package processor;

import enums.LogLevel;

/**
 * The Chain of Responsibility base. Each processor holds a reference to the
 * NEXT one in the chain. Its default log() just forwards the message along;
 * concrete processors override it to HANDLE their own level, and call
 * super.log() to pass anything else on.
 */
public abstract class LogProcessor {
    protected LogProcessor next;

    protected LogProcessor(LogProcessor next) {
        this.next = next;
    }

    public void log(LogLevel level, String message) {
        if (next != null) {
            next.log(level, message); // not handled here -> pass it along
        }
    }
}
