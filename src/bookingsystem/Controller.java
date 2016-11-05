package bookingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {

    AbstractDAO hotelDAO = new HotelDAO();
    AbstractDAO userDAO = new UserDAO();


    List<Hotel> findHotelByName(String name) {
        // check User for regist

        List<Hotel> result = new ArrayList<>();
        List<Hotel> temp = hotelDAO.getAlll();
        for (Hotel hotel : temp)
            if (name.equals(hotel.getName()))
                result.add(hotel);
        return result;
    }

    List<Hotel> findHotelByCity(String city) {
        // check User for regist
        List<Hotel> result = new ArrayList<>();
        List<Hotel> temp = hotelDAO.getAlll();
        for (Hotel hotel : temp)
            if (city.equals(hotel.getCity()))
                result.add(hotel);
        return result;
    }

    void bookRoom(long roomId, long userId, long hotelId) {
        //TODO
    }

    void cancelReservation(long roomId, long userId, long hotelId) {
        //TODO
    }

    ArrayList<Room> findRoom(Map<String, String> params) {
        //TODO
        return null;
    }
}
