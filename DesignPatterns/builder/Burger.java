/**
 * Builder: construct an object step by step with readable, chainable calls,
 * instead of a giant constructor like new Burger("sesame", 2, true, false, ...).
 * Great when there are many optional fields.
 */
public class Burger {
    private final String bun;
    private final int patties;
    private final boolean cheese;
    private final boolean lettuce;

    private Burger(Builder b) {          // only the Builder can build a Burger
        this.bun = b.bun;
        this.patties = b.patties;
        this.cheese = b.cheese;
        this.lettuce = b.lettuce;
    }

    @Override
    public String toString() {
        return "Burger{bun=" + bun + ", patties=" + patties
                + ", cheese=" + cheese + ", lettuce=" + lettuce + "}";
    }

    public static class Builder {
        private String bun = "plain";   // sensible defaults
        private int patties = 1;
        private boolean cheese = false;
        private boolean lettuce = false;

        public Builder bun(String bun)      { this.bun = bun;         return this; }
        public Builder patties(int n)       { this.patties = n;       return this; }
        public Builder cheese(boolean c)    { this.cheese = c;        return this; }
        public Builder lettuce(boolean l)   { this.lettuce = l;       return this; }

        public Burger build() { return new Burger(this); }
    }
}
