package bookingsystem.model;

import bookingsystem.dao.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Controller {

    private static HotelDAOImpl hotelDAO = new HotelDAOImpl(new RoomDAOImpl());
    private static AbstractDAO userDAO = new UserDAOImpl();
    public static CurUser curUser = new CurUser();

    static {
        List roomsHotel1 = new ArrayList();
        roomsHotel1.add(new Room(1, 100, 4, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(2, 400, 2, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(3, 500, 3, "Hotel1", "Kiev", null));

        hotelDAO.save(new Hotel(1, "Hotel1", "Kiev", 1, roomsHotel1));

        List roomsHotel2 = new ArrayList();
        roomsHotel2.add(new Room(1, 100, 4, "Hotel2", "London", null));
        roomsHotel2.add(new Room(2, 400, 2, "Hotel2", "London", null));
        roomsHotel2.add(new Room(3, 500, 3, "Hotel2", "London", null));

        hotelDAO.save(new Hotel(2, "Hotel2", "London", 13, roomsHotel2));

        List roomsHotel3 = new ArrayList();
        roomsHotel3.add(new Room(1, 100, 4, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(2, 400, 2, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(3, 500, 3, "Hotel3", "Kiev", null));

        hotelDAO.save(new Hotel(3, "Hotel3", "Kiev", 13, roomsHotel3));

    }


    public List<Hotel> findHotelByName(String name) {
        List result;
        result =hotelDAO.getAll().stream()
                .filter(n -> name.equals(n.getName()))
                .collect(Collectors.toList());
        return result;
    }

    public List<Hotel> findHotelByCity(String city) {
        List result;
        result = hotelDAO.getAll().stream()
                .filter(n -> city.equals(n.getCity()))
                .collect(Collectors.toList());

        return result;
    }

    public void bookRoom(long roomId, long userId, long hotelId) {
        Hotel foundHotel = (Hotel) hotelDAO.findById(hotelId);
        if (foundHotel != null) {
            Room foundRoom = null;
            List<Room> listFoundRooms = foundHotel.getRooms().stream()
                    .filter(room -> room.getId() == roomId)
                    .collect(Collectors.toList());
            if (listFoundRooms.size() == 0) {
                System.out.println("Error. With room ID: " + roomId);
                foundRoom = null;
            }
            if (foundRoom != null) {
                UserDAO userDB = (UserDAO) userDAO;
                User foundUser = userDB.findUserById(userId);
                if (foundUser != null) {
                    foundRoom.setUserReserved(foundUser);
                }
            }
        }
    }

    public void cancelReservation(long roomId, long userId, long hotelId) {
        Hotel foundHotel = (Hotel) hotelDAO.findById(hotelId);
        if (foundHotel != null) {
            Room foundRoom = null;
            List<Room> listFoundRooms = foundHotel.getRooms().stream()
                    .filter(room -> room.getId() == roomId)
                    .collect(Collectors.toList());
            if (listFoundRooms.size() == 0) {
                System.out.println("Error. With room ID: " + roomId);
                foundRoom = null;
            }
            if (foundRoom != null) {
                UserDAO userDB = (UserDAO) userDAO;
                User foundUser = userDB.findUserById(userId);
                if (foundUser != null) {
                    foundRoom.setUserReserved(null);
                }
            }
        }

    }

    public ArrayList<Room> findRoom(Map<String, String> params) {
        List<Room> findRoom = new ArrayList<>();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String parametr1 = entry.getKey();
            String parametr2 = entry.getValue();
            switch (parametr1) {
                case "price":

/*                    findRoom.addAll(hotelDAO.getAll().stream()
                            .filter()
                            .collect(Collectors.toList()));*/
                    break;


                default:
                    System.out.println("Error");
            }
        }
        return null;
    }


    public void registerUser(User user) {
        userDAO.save(user);
        System.out.println("User " + user.getFirstName() + " " + user.getLastName() + "be registered.");
    }
}
