package bookingsystem.dao;

import bookingsystem.model.*;

import java.util.List;

public interface HotelDAO {

    Hotel saveHotel(Hotel h, List<Room> rooms);

    void saveRooms(Hotel h, List<Room> rooms);

    List<Room> getRooms(Hotel h);

    void deleteHotel(Hotel h);

    void deleteAllFromList(List<Hotel> hotelList);

    void deleteHotelById(long id);

    Hotel findHotelById(long id);

    List<Hotel> getAllHotels();

    List<Hotel> findHotelByName(String name);

    List<Hotel> findHotelByCity(String city);
}
