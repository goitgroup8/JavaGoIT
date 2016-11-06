package bookingsystem.dao;


import java.util.List;
import bookingsystem.model.Room;


public interface RoomDAO {
    Room saveRoom(Room r);

    void deleteRoom(Room r);

    void deleteAllFromList(List<Room> roomList);

    void saveAllFromList(List<Room> roomList);

    List<Room> getAll();

    void deleteRoomById(long id);

    Room findRoomById(long id);
}
