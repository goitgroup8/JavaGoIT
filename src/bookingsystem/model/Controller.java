package bookingsystem.model;

import bookingsystem.dao.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Controller {

    private static RoomDAOImpl roomDAO = new RoomDAOImpl();
    private static HotelDAOImpl hotelDAO = new HotelDAOImpl(roomDAO);
    private static UserDAOImpl userDAO = new UserDAOImpl();
    public static CurUser curUser = new CurUser();

    static {
        List<Room> roomsHotel1 = new ArrayList<Room>();
        roomsHotel1.add(new Room(1, 100, 4, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(2, 100, 2, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(3, 1500, 3, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(4, 500, 2, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(5, 2500, 3, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(6, 1500, 4, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(7, 2500, 3, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(8, 4500, 5, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(9, 500, 3, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(10, 300, 2, "Hotel1", "Kiev", null));
        hotelDAO.saveHotel(new Hotel(1, "Hotel1", "Kiev", 1, roomsHotel1));

        List<Room> roomsHotel2 = new ArrayList<>();
        roomsHotel2.add(new Room(1, 100, 4, "Hotel2", "London", null));
        roomsHotel2.add(new Room(2, 400, 2, "Hotel2", "London", null));
        roomsHotel2.add(new Room(3, 200, 1, "Hotel2", "London", null));
        roomsHotel2.add(new Room(4, 1500, 3, "Hotel2", "London", null));
        roomsHotel2.add(new Room(5, 2500, 2, "Hotel2", "London", null));
        roomsHotel2.add(new Room(6, 3200, 3, "Hotel2", "London", null));
        roomsHotel2.add(new Room(7, 4500, 5, "Hotel2", "London", null));
        roomsHotel2.add(new Room(8, 1500, 4, "Hotel2", "London", null));
        roomsHotel2.add(new Room(9, 700, 4, "Hotel2", "London", null));
        roomsHotel2.add(new Room(10, 300, 3, "Hotel2", "London", null));
        hotelDAO.saveHotel(new Hotel(2, "Hotel2", "London", 13, roomsHotel2));

        List<Room> roomsHotel3 = new ArrayList<Room>();
        roomsHotel3.add(new Room(1, 100, 4, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(2, 400, 2, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(3, 700, 3, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(4, 1500, 5, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(5, 500, 3, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(6, 200, 2, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(7, 1500, 5, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(8, 2500, 5, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(9, 300, 1, "Hotel3", "Kiev", null));
        roomsHotel3.add(new Room(10, 500, 3, "Hotel3", "Kiev", null));
        hotelDAO.saveHotel(new Hotel(3, "Hotel3", "Kiev", 13, roomsHotel3));
    }

    public List<Hotel> findHotelByName(String name) {
        List<Hotel> result;
        if ((curUser.getCurUser() == null) || (!userDAO.getAll().contains(curUser.getCurUser()))) {
            System.out.println("User not found");
            return new ArrayList<>();
        }
        result = hotelDAO.getAll().stream()
                .filter(n -> name.equals(n.getName()))
                .collect(Collectors.toList());
        if (result.size() == 0)
            System.out.println("Your search - " + name + " - did not match any hotels.");
        return result;
    }

    public List<Hotel> findHotelByCity(String city) {
        List<Hotel> result;
        if ((curUser.getCurUser() == null) || (!userDAO.getAll().contains(curUser.getCurUser()))) {
            System.out.println("User not found");
            return new ArrayList<>();
        }
        result = hotelDAO.getAll().stream()
                .filter(n -> city.equals(n.getCity()))
                .collect(Collectors.toList());
        if (result.size() == 0)
            System.out.println("Your search - " + city + " - did not match any hotels.");
        return result;
    }

    public void bookRoom(long roomId, long userId, long hotelId) {
        Hotel foundHotel = hotelDAO.findById(hotelId);
        User foundUser = userDAO.findUserById(userId);
        Room foundRoom = null;
        if (foundHotel != null) {
            try {
                foundRoom = foundHotel.getRooms().get((int) roomId);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Your search room id - " + roomId + " -  did not match any rooms");
            }
            if (foundRoom != null) {
                if (foundRoom.getUserReserved() == null) {
                    if (foundUser != null) {
                        foundRoom.setUserReserved(foundUser);
                        System.out.println("Booking successful");
                    } else {
                        System.out.println("Your search user id - " + userId + " -  did not match any users");
                    }
                } else {
                    System.out.println("Room was booking");
                }
            }
        } else {
            System.out.println("Your search hotel id - " + hotelId + " -  did not match any hotels");
        }
    }

    public void cancelReservation(long roomId, long userId, long hotelId) {
        Hotel foundHotel = hotelDAO.findById(hotelId);
        User foundUser = userDAO.findUserById(userId);
        Room foundRoom = null;
        if (foundHotel != null) {
            try {
                foundRoom = foundHotel.getRooms().get((int) roomId);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Your search room id - " + roomId + " -  did not match any rooms");
            }
            if (foundRoom != null) {
                if (foundRoom.getUserReserved() == foundUser) {
                    if (foundUser != null) {
                        foundRoom.setUserReserved(null);
                        System.out.println("Cancel reservation successful");
                    } else {
                        System.out.println("Your search user id - " + userId + " -  did not match any users");
                    }
                } else {
                    System.out.println("User can't cansel reservation");
                }
            }
        } else {
            System.out.println("Your search hotel id - " + hotelId + " -  did not match any hotels");
        }
    }

    private List<Room> filterRoomList(List<Room> roomList, String key, String value) {
        List<Room> result = roomList;
        switch (key) {
            case "price":
                result = roomList.stream()
                        .filter(r -> Integer.parseInt(value) == r.getPrice())
                        .collect(Collectors.toList());
                break;
            case "hotel":
                result = roomList.stream()
                        .filter(r -> value.equalsIgnoreCase(r.getHotelName()))
                        .collect(Collectors.toList());
                break;
            case "persons":
                result = roomList.stream()
                        .filter(r -> Integer.parseInt(value) == r.getPersons())
                        .collect(Collectors.toList());
                break;
            case "city":
                result = roomList.stream()
                        .filter(r -> value.equalsIgnoreCase(r.getCityName()))
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Your client has issued a malformed or illegal request. - " + key + "\nSuggestions: \n- Make sure that all words are spelled correctly.\n" +
                        "- Try different keywords.\nExample: price, hotel, persons, city.");
        }

        return result;
    }

    public List<Room> findRoom(Map<String, String> params) {
        List<Room> foundRooms = new ArrayList<>();
        boolean isFirst = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (isFirst) {
                foundRooms = filterRoomList(roomDAO.getAll(), key, value);
                isFirst = false;
            } else
                foundRooms = filterRoomList(foundRooms, key, value);
        }

        return foundRooms;
    }

    public void registerUser(User user) {
        userDAO.saveUser(user);
        System.out.println("User " + user.getFirstName() + " " + user.getLastName() + " be registered.");
    }
}
