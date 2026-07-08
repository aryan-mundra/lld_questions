package model;

/** A film. The same movie can play in many shows across screens/times. */
public class Movie {
    private final String id;
    private final String title;

    public Movie(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
}
