package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The Subject. It keeps a list of observers and notifies ALL of them whenever
 * something happens (here: a new upload). Observers can join/leave any time.
 */
public class Channel {
    private final List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer o)   { subscribers.add(o); }
    public void unsubscribe(Observer o) { subscribers.remove(o); }

    public void upload(String video) {
        System.out.println("Channel uploaded: " + video);
        for (Observer o : subscribers) {   // notify everyone
            o.update(video);
        }
    }
}
