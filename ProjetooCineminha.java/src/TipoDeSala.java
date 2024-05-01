public enum TipoDeSala {
    BASIC(20), _3D(40), VIP(80);

    private final double price;

    TipoDeSala(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}