public class Main {
    public static void main(String[] args) {
        Shape s1 = ShapeFactory.create("circle");
        Shape s2 = ShapeFactory.create("square");
        s1.draw();
        s2.draw();
    }
}
