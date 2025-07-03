public class LuxRoom extends ProRoom{
    public LuxRoom(int numberRoom, boolean booking) {
        super(numberRoom, Prices.LUX, booking);
    }

    protected LuxRoom(int numberRoom, Prices priceEnum, boolean booking){
        super(numberRoom, priceEnum ,booking);
    }
}
