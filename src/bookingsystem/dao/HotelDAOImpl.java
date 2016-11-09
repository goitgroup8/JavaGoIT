package bookingsystem.dao;

import bookingsystem.model.Hotel;
import bookingsystem.model.Room;

import java.util.List;
import java.util.stream.Collectors;

public class HotelDAOImpl extends AbstractDAOImpl<Hotel> implements HotelDAO {
    private RoomDAOImpl rdao;

    public HotelDAOImpl(RoomDAOImpl rdao) {
        this.rdao = rdao;
    }

    public Hotel saveHotel(Hotel hotel, List<Room> rooms) {
        saveRooms(hotel, rooms);
        return save(hotel);
    }

    public void saveRooms(Hotel hotel, List<Room> rooms) {
        rooms.forEach(r -> r.setHotel(hotel));
        rdao.saveAll(rooms);
    }

    public List<Room> getRooms(Hotel hotel) {
        return rdao.getRoomsByHotelId(hotel.getId());
    }

    public Hotel findHotelById(long id) {
        Hotel h = findById(id);
        List<Room> rooms = rdao.getRoomsByHotelId(h.getId());
        h.setRooms(rooms);
        return h;
    }

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = getAll();
        hotels.forEach(h -> {
            List<Room> rooms = rdao.getRoomsByHotelId(h.getId());
            h.setRooms(rooms);
        });

        return hotels;
    }

    public void deleteHotel(Hotel hotel) {
        deleteHotelById(hotel.getId());
    }

    public void deleteAllFromList(List<Hotel> hotelList) {
        hotelList.forEach(h -> deleteHotel(h));
    }

    public void deleteHotelById(long id) {
        Hotel h = findById(id);
        if (h != null) {
            List<Room> rooms = rdao.getRoomsByHotelId(id);
            rdao.deleteAll(rooms);
            deleteById(id);
        }
    }

    public List<Hotel> findHotelByName(String name) {
        List<Hotel> hotels = getAll().stream()
                .filter(n -> name.equals(n.getName()))
                .collect(Collectors.toList());
        hotels.forEach(h -> {
            List<Room> rooms = rdao.getRoomsByHotelId(h.getId());
            h.setRooms(rooms);
        });

        return hotels;
    }

    public List<Hotel> findHotelByCity(String city) {
        List<Hotel> hotels = getAll().stream()
                .filter(n -> city.equals(n.getCity()))
                .collect(Collectors.toList());
        hotels.forEach(h -> {
            List<Room> rooms = rdao.getRoomsByHotelId(h.getId());
            h.setRooms(rooms);
        });

        return hotels;
    }
}
