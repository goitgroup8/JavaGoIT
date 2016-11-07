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
        int roomId = 0;
        roomsHotel1.add(new Room(++roomId, 100, 4, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 100, 2, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 1500, 3, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 500, 2, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 2500, 3, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 1500, 4, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 2500, 3, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 4500, 5, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 500, 3, "Hotel1", "Kiev", null));
        roomsHotel1.add(new Room(++roomId, 300, 2, "Hotel1", "Kiev", null));
        hotelDAO.saveHotel(new Hotel(1, "Hotel1", "Kiev", 1), roomsHotel1);

        List<Room> roomsHotel2 = new ArrayList<Room>();
        roomsHotel2.add(new Room(++roomId, 100, 4, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 400, 2, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 700, 3, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 1500, 5, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 500, 3, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 200, 2, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 1500, 5, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 2500, 5, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 300, 1, "Hotel2", "Kiev", null));
        roomsHotel2.add(new Room(++roomId, 500, 3, "Hotel2", "Kiev", null));
        hotelDAO.saveHotel(new Hotel(2, "Hotel2", "Kiev", 3), roomsHotel2);

        List<Room> roomsHotel3 = new ArrayList<>();
        roomsHotel3.add(new Room(++roomId, 100, 4, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 400, 2, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 200, 1, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 1500, 3, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 2500, 2, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 3200, 3, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 4500, 5, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 1500, 4, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 700, 4, "Hotel3", "London", null));
        roomsHotel3.add(new Room(++roomId, 300, 3, "Hotel3", "London", null));
        hotelDAO.saveHotel(new Hotel(3, "Hotel3", "London", 13), roomsHotel3);

        List<Room> roomsHotel4 = new ArrayList<Room>();
        roomsHotel4.add(new Room(++roomId, 600, 3, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 400, 1, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 800, 2, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 1600, 4, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 600, 2, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 1000, 2, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 2000, 5, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 4000, 2, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 200, 1, "Hotel4", "London", null));
        roomsHotel4.add(new Room(++roomId, 700, 3, "Hotel4", "London", null));
        hotelDAO.saveHotel(new Hotel(4, "Hotel4", "London", 5), roomsHotel4);

        List<Room> roomsHotel5 = new ArrayList<Room>();
        roomsHotel5.add(new Room(++roomId, 300, 2, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 200, 1, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 400, 2, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 600, 3, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 800, 2, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 1000, 4, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 800, 4, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 900, 3, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 200, 1, "Hotel5", "Amsterdam", null));
        roomsHotel5.add(new Room(++roomId, 600, 3, "Hotel5", "Amsterdam", null));
        hotelDAO.saveHotel(new Hotel(5, "Hotel5", "Amsterdam", 3), roomsHotel5);

        List<Room> roomsHotel6 = new ArrayList<Room>();
        roomsHotel6.add(new Room(++roomId, 300, 3, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 1000, 4, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 800, 2, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 900, 3, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 400, 1, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 1500, 5, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 700, 3, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 900, 3, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 800, 2, "Hotel6", "Amsterdam", null));
        roomsHotel6.add(new Room(++roomId, 600, 2, "Hotel6", "Amsterdam", null));
        hotelDAO.saveHotel(new Hotel(6, "Hotel6", "Amsterdam", 4), roomsHotel6);

    }

    private boolean checkCurrUser() {
        if (curUser.getCurUser() == null || !userDAO.getAll().contains(curUser.getCurUser())) {
            System.out.println("User not found");
            return false;
        }
        return true;
    }

    private void checkSizeArray(String str, List<Hotel> result) {
        if (result.size() == 0)
            System.out.println("Your search - " + str + " - did not match any hotels.");
    }

    public List<Hotel> findHotelByName(String name) {

        if (!checkCurrUser()) {
            return new ArrayList<>();
        }

        List<Hotel> result = hotelDAO.getAll().stream()
                .filter(n -> name.equals(n.getName()))
                .collect(Collectors.toList());

        checkSizeArray(name, result);

        return result;
    }

    public List<Hotel> findHotelByCity(String city) {

        if (!checkCurrUser()) {
            return new ArrayList<>();
        }

        List<Hotel> result = hotelDAO.getAll().stream()
                .filter(n -> city.equals(n.getCity()))
                .collect(Collectors.toList());

        checkSizeArray(city, result);

        return result;
    }


    public void bookRoom(long roomId, long userId, long hotelId) {
        boolean flag;
        Hotel hotel = hotelDAO.findHotelById(hotelId);
        User user = userDAO.findUserById(userId);
        Room room = roomDAO.findRoomByIdWithHotelCheck(hotelId, roomId);
        flag = checkCurrUser() && checkHotelRoomUserNotNull(roomId, userId, hotelId, hotel, user, room);
        if (flag) {
            if (room.getUserReserved() == null) {
                room.setUserReserved(user);
                System.out.println("Successful");
            } else {
                System.out.println("Room was booking");
            }
        }
    }

    public void cancelReservation(long roomId, long userId, long hotelId) {
        boolean flag;
        Hotel hotel = hotelDAO.findHotelById(hotelId);
        User user = userDAO.findUserById(userId);
        Room room = roomDAO.findRoomByIdWithHotelCheck(hotelId, roomId);
        flag = checkCurrUser() && checkHotelRoomUserNotNull(roomId, userId, hotelId, hotel, user, room);
        if (flag) {
            if (room.getUserReserved() != null && userId == user.getId()) {
                room.setUserReserved(null);
                System.out.println("Cansel reservation is successful");
            } else {
                System.out.println("You cann't cancel room!");
            }
        }
    }

    private boolean checkHotelRoomUserNotNull(long roomId, long userId, long hotelId, Hotel hotel, User user, Room room) {
        boolean flag = true;
        if (hotel == null) {
            flag = false;
            System.out.println("Your search hotel id - " + hotelId + " -  did not match any hotels");
        } else {
            if (room == null) {
                flag = false;
                System.out.println("Your search room id - " + roomId + " -  did not match any rooms.");

            } else {
                if (user == null) {
                    flag = false;
                    System.out.println("Your search user id - " + userId + " -  did not match any users");
                }
            }
        }
        return flag;
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
                        .filter(r -> value.equalsIgnoreCase(r.getHotel().getName()))
                        .collect(Collectors.toList());
                break;
            case "persons":
                result = roomList.stream()
                        .filter(r -> Integer.parseInt(value) == r.getPersons())
                        .collect(Collectors.toList());
                break;
            case "city":
                result = roomList.stream()
                        .filter(r -> value.equalsIgnoreCase(r.getHotel().getCity()))
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
        if (!checkCurrUser()) {
            return foundRooms;
        }


        boolean isFirst = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null || value == null){
                System.out.println("You entered \"null\" :)");
                return foundRooms;
            }
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
