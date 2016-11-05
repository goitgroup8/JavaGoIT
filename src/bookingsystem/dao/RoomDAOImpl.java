package bookingsystem.dao;

import bookingsystem.model.Room;

import java.util.List;

public class RoomDAOImpl extends AbstractDAOImpl<Room> implements RoomDAO {
    public Room saveRoom(Room room) {
        return save(room);
    }

    public void deleteRoom(Room room) {
        delete(room);
    }

    public void deleteAllFromList(List<Room> roomList) {
        deleteAll(roomList);
    }

    public void saveAllFromList(List<Room> roomList) {
        saveAll(roomList);
    }

    public List<Room> getAll() {
        return getList();
    }

    public void deleteRoomById(long id) {
        deleteById(id);
    }

    public Room findRoomById(long id) {
        return findById(id);
    }
}
