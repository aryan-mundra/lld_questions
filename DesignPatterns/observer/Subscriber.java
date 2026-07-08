package observer;

public class Subscriber implements Observer {
    private final String name;

    public Subscriber(String name) { this.name = name; }

    public void update(String video) {
        System.out.println(name + " got notified: new video \"" + video + "\"");
    }
}
