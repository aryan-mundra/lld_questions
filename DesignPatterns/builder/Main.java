public class Main {
    public static void main(String[] args) {
        // read it top to bottom — only set what you care about
        Burger burger = new Burger.Builder()
                .bun("sesame")
                .patties(2)
                .cheese(true)
                .build();

        System.out.println(burger);
    }
}
