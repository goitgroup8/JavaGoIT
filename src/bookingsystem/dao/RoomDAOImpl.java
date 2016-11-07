package bookingsystem.dao;

import bookingsystem.model.Room;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Room findRoomByIdWithHotelCheck(long hotelId, long roomId) {
        List<Room> rooms = getRoomsByHotelId(hotelId);
        Optional<Room> op = rooms.stream().filter(r -> r.getId() == roomId).findFirst();
        if (op.isPresent())
            return op.get();
        else
            return null;
    }

    public List<Room> getRoomsByHotelId(long id) {
        List<Room> result = getList().stream().filter(r -> r.getHotel().getId() == id).collect(Collectors.toList());
        return result;
    }
}
