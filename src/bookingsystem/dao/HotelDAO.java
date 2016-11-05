package bookingsystem.dao;

import bookingsystem.model.Hotel;

import java.util.List;

public interface HotelDAO {
    Hotel saveHotel(Hotel u);

    void deleteHotel(Hotel u);

    void deleteAllFromList(List<Hotel> roomList);

    void saveAllFromList(List<Hotel> roomList);

    List<Hotel> getAll();

    void deleteHotelById(long id);

    Hotel findHotelById(long id);
}
