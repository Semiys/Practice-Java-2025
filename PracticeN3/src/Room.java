import java.util.Random;
public abstract class Room{
    private int numberRoom;
    private int maxCountPeopleInRoom;
    private int price;
    private boolean booking;

    private static final Random randomCountPeople=new Random();

    public Room(int numberRoom,Prices priceEnum, boolean booking) {
        this.numberRoom = numberRoom;
        this.maxCountPeopleInRoom = randomCountPeople.nextInt(1,5);
        this.price =priceEnum.getPrice();
        this.booking = booking;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public boolean isBooking() {
        return booking;
    }

    public void setBooking(boolean booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberRoom=" + numberRoom +
                ", maxCountPeopleInRoom=" + maxCountPeopleInRoom +
                ", price=" + price +
                ", booking=" + booking +
                '}';
    }


}
