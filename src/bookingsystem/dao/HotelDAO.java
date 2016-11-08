package bookingsystem.dao;

import bookingsystem.model.*;

import java.util.List;

public interface HotelDAO {

    Hotel saveHotel(Hotel h, List<Room> rooms);

    void saveRooms(Hotel h, List<Room> rooms);

    void deleteHotel(Hotel h);

    void deleteAllFromList(List<Hotel> hotelList);

    void deleteHotelById(long id);

    List<Hotel> findHotelByName(String name);

    List<Hotel> findHotelByCity(String city);
}
