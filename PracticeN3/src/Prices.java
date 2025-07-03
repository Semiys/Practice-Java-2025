public enum Prices {
    ECONOMY(10000),
    STANDARD(15000),
    LUX(30000),
    ULTRA_LUX(60000);

    private final int price;


    Prices(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
