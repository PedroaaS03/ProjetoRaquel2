public enum TipoDeSala {
    BASIC(20), THREE_D(40), VIP(80);

    private final double price;

    TipoDeSala(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}