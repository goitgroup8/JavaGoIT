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

        User user = new User(1, "Artur", "Kovalchuk");
        User user1 = new User(2, "Oleg", "Green");
        User user2 = new User(3, "Ivan", "Toropov");
        User user3 = new User(4, "Joker", "Joker");
        controller.registerUser(user);
        controller.registerUser(user1);
        controller.registerUser(user2);
        System.out.println();

        controller.curUser.setCurUser(user);
        System.out.println();

        controller.findHotelByCity("Kiev").forEach(System.out::println);
        controller.findHotelByName("Hotel2").forEach(System.out::println);
        controller.findHotelByCity("Kiev1").forEach(System.out::println);
        controller.findHotelByName("Hotel26").forEach(System.out::println);
        System.out.println();

        controller.bookRoom(1,1,1);
        System.out.println();

        Map<String, String> params = new HashMap<>();
        params.put("hotel","hotel2");
        params.put("price","100");
        List<Room> foundRooms = controller.findRoom(params);
        foundRooms.forEach(System.out::println);

        params.clear();
        params.put("city","kiev");
        params.put("price","100");
        foundRooms = controller.findRoom(params);
        foundRooms.forEach(System.out::println);

        System.out.println();
        controller.bookRoom(1,1,1);
        System.out.println();
        controller.bookRoom(2,23,121);
        System.out.println();
        controller.bookRoom(1,13,1);
        System.out.println();
        controller.cancelReservation(1,1,1);
    }
}
