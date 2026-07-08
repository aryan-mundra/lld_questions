/**
 * Factory: hides object creation behind one method. Callers ask for "circle"
 * and get a Shape back — they never call 'new Circle()' themselves, so adding
 * a new shape only touches this factory, not every caller.
 */
public class ShapeFactory {
    public static Shape create(String type) {
        String t = type.toLowerCase();
        if (t.equals("circle")) {
            return new Circle();
        } else if (t.equals("square")) {
            return new Square();
        } else {
            throw new IllegalArgumentException("Unknown shape: " + type);
        }
    }
}
