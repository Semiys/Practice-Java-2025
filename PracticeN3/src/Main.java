public class Main {
    public static void main(String[] args){
        StandardRoom myRoom=new StandardRoom(42,false);
        HotelRoomService service=new HotelRoomService();

        service.reserve(myRoom);
        System.out.println("После бронирования: "+ myRoom);

        try{
            service.reserve(myRoom);
        }catch(RoomIsBookedException e){
            System.err.println(e.getMessage());
        }

        service.free(myRoom);
        System.out.println("После освобождения комнаты: "+ myRoom);

        service.clean(myRoom);

        System.out.println("\n");

        PremiumHotelService premiumService=new PremiumHotelService();
        LuxRoom myLuxRoom=new LuxRoom(222,false);
        UltraLuxRoom myUltraLuxRoom=new UltraLuxRoom(777,false);
        EconomyRoom myEconomyRoom=new EconomyRoom(555,true);

        premiumService.reserve(myLuxRoom);
        premiumService.foodDelivery(myLuxRoom);
        System.out.println("Состояние люкса: "+ myLuxRoom);
        System.out.println("\n");
        //Ошибки
        premiumService.foodDelivery(myUltraLuxRoom);
        //premiumService.foodDelivery(myEconomyRoom);






    }
}
