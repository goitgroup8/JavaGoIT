package bookingsystem.dao;


import java.util.List;
import bookingsystem.model.Room;


public interface RoomDAO {
    List<Room> getRoomsByHotelId(long id);

    Room findRoomByIdWithHotelCheck(long hotelId, long roomId);
}
