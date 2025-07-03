public class HotelRoomService implements RoomService<Room>{
    @Override
    public void clean(Room room){
        System.out.println("Выполнена уборка в комнате с номером: " + room.getNumberRoom() );
    }

    @Override
    public void reserve(Room room){
        if (room.isBooking()){
            throw new RoomIsBookedException("Ошибка: Комната с номером: "+ room.getNumberRoom() + " уже забронирована");
        }
        else{
            room.setBooking(true);
            System.out.println("Комната с номером: "+ room.getNumberRoom() + " успешно забронирована");
        }

    }

    @Override
    public void free(Room room){
        if (room.isBooking()){
            room.setBooking(false);
            System.out.println("Комната с номером: "+ room.getNumberRoom() + " успешно освобождена");
        }
        else{
            System.out.println("Комната с номером: "+ room.getNumberRoom() + " и так была свободна");
        }
    }
}
