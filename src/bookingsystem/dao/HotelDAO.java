package bookingsystem.dao;

import bookingsystem.model.Hotel;

import java.util.List;

public interface HotelDAO {
    Hotel saveHotel(Hotel h);

    void deleteHotel(Hotel h);

    void deleteAllFromList(List<Hotel> hotelList);

    void saveAllFromList(List<Hotel> hotelList);

    List<Hotel> getAll();

    void deleteHotelById(long id);

    Hotel findHotelById(long id);
}
