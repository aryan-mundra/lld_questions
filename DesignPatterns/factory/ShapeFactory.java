/**
 * Factory: hides object creation behind one method. Callers ask for "circle"
 * and get a Shape back — they never call 'new Circle()' themselves, so adding
 * a new shape only touches this factory, not every caller.
 */
public class ShapeFactory {
    public static Shape create(String type) {
        switch (type.toLowerCase()) {
            case "circle": return new Circle();
            case "square": return new Square();
            default: throw new IllegalArgumentException("Unknown shape: " + type);
        }
    }
}
