package bookingsystem.dao;

import bookingsystem.model.Hotel;
import bookingsystem.model.Room;

import java.util.List;

public class HotelDAOImpl extends AbstractDAOImpl<Hotel> implements HotelDAO {
    private RoomDAOImpl rdao;

    public HotelDAOImpl(RoomDAOImpl rdao) {
        this.rdao = rdao;
    }

    public Hotel saveHotel(Hotel hotel) {
        return save(hotel);
    }

    public Hotel saveHotel(Hotel hotel, List<Room> rooms) {
        saveRooms(hotel, rooms);
        return save(hotel);
    }

    public void saveRooms(Hotel hotel, List<Room> rooms) {
        rooms.forEach(r -> r.setHotel(hotel));
        rdao.saveAll(rooms);
    }

    public void deleteHotel(Hotel hotel) {
        deleteHotelById(hotel.getId());
    }

    public void deleteAllFromList(List<Hotel> hotelList) {
        hotelList.forEach(h -> deleteHotel(h));
    }

    public void saveAllFromList(List<Hotel> hotelList) {
        hotelList.forEach(h -> saveHotel(h));
    }

    public List<Hotel> getAll() {
        return getList();
    }

    public void deleteHotelById(long id) {
        Hotel h = findHotelById(id);
        if (h != null) {
            List<Room> rooms = rdao.getRoomsByHotelId(id);
            rdao.deleteAll(rooms);
            deleteById(id);
        }
    }

    public Hotel findHotelById(long id) {
        return findById(id);
    }
}
