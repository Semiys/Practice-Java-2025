public class PremiumHotelService implements LuxRoomService<LuxRoom> {
    @Override
    public void clean(LuxRoom room){
        System.out.println("Выполнена VIP-уборка в комнате с номером: " + room.getNumberRoom() );
    }

    @Override
    public void reserve(LuxRoom room){
        if (room.isBooking()){
            throw new RoomIsBookedException("Ошибка: VIP-Комната с номером: "+ room.getNumberRoom() + " уже забронирована");
        }
        else{
            room.setBooking(true);
            System.out.println("VIP-Комната с номером: "+ room.getNumberRoom() + " успешно забронирована");
        }

    }

    @Override
    public void free(LuxRoom room){
        if (room.isBooking()){
            room.setBooking(false);
            System.out.println("VIP-Комната с номером: "+ room.getNumberRoom() + " успешно освобождена");
        }
        else{
            System.out.println("VIP-Комната с номером: "+ room.getNumberRoom() + " и так была свободна");
        }
    }

    @Override
    public void foodDelivery(LuxRoom room){
        System.out.println("Доставка еды в VIP-комнату с номером: "+ room.getNumberRoom());
    }
}
