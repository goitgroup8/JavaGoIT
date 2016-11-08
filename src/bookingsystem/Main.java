package bookingsystem;

import bookingsystem.model.Controller;

import bookingsystem.model.Room;
import bookingsystem.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        User user1 = new User(1, "Steve", "Jobs");
        User user2 = new User(2, "Sergey", "Brin");
        User user3 = new User(3, "Mark", "Zuckerberg");
        User user4 = new User(4, "Arthur", "Dent");
        User user5 = new User(5, "Zaphod", "Beeblebrox");

        System.out.println("Start. Users registration.");
        controller.registerUser(user1);
        controller.registerUser(user2);
        controller.registerUser(user3);
        System.out.println("Finish. Users registration.\n");
        System.out.println("Try find hotels by name without user authorization");
        controller.findHotelByName("Hotel1").forEach(System.out::println);

        System.out.println("\nTry find hotels by city without user authorization");
        controller.findHotelByCity("Kiev").forEach(System.out::println);

        System.out.println("\nUser authorization - user5 - User not registrate ");
        Controller.curUser.setCurUser(user5);

        System.out.println("\nUser authorization");
        Controller.curUser.setCurUser(user1);

        System.out.println("\nFind hotels by city with user authorization.\nRequest #1 - Kiev");
        controller.findHotelByCity("Kiev").forEach(System.out::println);
        System.out.println("\nRequest #2 - Kiev1");
        controller.findHotelByCity("Kiev1").forEach(System.out::println);
        System.out.println("\nRequest #3 - null");
        controller.findHotelByCity(null).forEach(System.out::println);
        System.out.println("\nFind hotels by name with user authorization.\nRequest #1 - Hotel26");
        controller.findHotelByName("Hotel26").forEach(System.out::println);
        System.out.println("\nRequest #2 - Hotel2");
        controller.findHotelByName("Hotel2").forEach(System.out::println);
        System.out.println("\nRequest #3 - null");
        controller.findHotelByName(null).forEach(System.out::println);

        List<Room> foundRooms;
        Map<String, String> params = new HashMap<>();
        System.out.println("\nFind rooms by parameters with user authorization.\nRequest #1 - hotel = hotel1, price = 100");
        params.put("hotel", "hotel1");
        params.put("price", "100");
        foundRooms = controller.findRoom(params);
        foundRooms.forEach(System.out::println);

        System.out.println("\nRequest #2 - city = kiev, price = 100");
        params.clear();
        params.put("city", "kiev");
        params.put("price", "100");
        foundRooms = controller.findRoom(params);
        foundRooms.forEach(System.out::println);

        System.out.println("\nRequest #3 - city = Amsterdam, price = 300");
        params.clear();
        params.put("city", "Amsterdam");
        params.put("price", "300");
        foundRooms = controller.findRoom(params);
        foundRooms.forEach(System.out::println);

        System.out.println("\nRequest #4 - city = null");
        params.clear();
        params.put("city", null);
        foundRooms = controller.findRoom(params);
        foundRooms.forEach(System.out::println);

        System.out.println("\nRequest #5 - null = city");
        params.clear();
        params.put(null, "city");
        foundRooms = controller.findRoom(params);
        foundRooms.forEach(System.out::println);
        params.clear();

        System.out.println("\nRequest #6 - null = null");
        params.put(null, null);
        foundRooms = controller.findRoom(params);
        foundRooms.forEach(System.out::println);

        System.out.println("\nRequest #7 - params = null");
        foundRooms = controller.findRoom(null);
        foundRooms.forEach(System.out::println);

        System.out.println("\nBooking room\nRequest #1 - roomId = 1, userId = 1, hotelId = 1");
        controller.bookRoom(1, 1, 1);
        System.out.println("\nRequest #2 - roomId = 1, userId = 2, hotelId = 1");
        controller.bookRoom(1, 2, 1);
        System.out.println("\nRequest #3 - roomId = 13, userId = 3, hotelId = 2");
        controller.bookRoom(13, 3, 2);
        System.out.println("\nRequest #4 - roomId = 13, userId = 3, hotelId = 25");
        controller.bookRoom(13, 3, 25);
        System.out.println("\nRequest #5 - roomId = 25, userId = 25, hotelId = 25");
        controller.bookRoom(25, 25, 25);

        System.out.println("\nCancel reservation room\nRequest #1 - roomId = 1, userId = 3, hotelId = 1");
        controller.cancelReservation(1, 3, 1);

        System.out.println("\nRequest #2 - roomId = 1, userId = 1, hotelId = 1");
        controller.cancelReservation(1, 1, 1);

        System.out.println("\nRequest #3 - roomId = 1, userId = 1, hotelId = 1");
        controller.cancelReservation(1, 1, 1);

        System.out.println("\nRequest #4 - roomId = 1, userId = 1, hotelId = 1");
        controller.cancelReservation(1, 1, 1);

        System.out.println("\nRequest #5 - roomId = 1, userId = 1, hotelId = 13");
        controller.cancelReservation(1, 1, 13);
    }
}
