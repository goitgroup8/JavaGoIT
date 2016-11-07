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

        controller.curUser.setCurUser(user);
        controller.findHotelByCity("Kiev1").forEach(System.out::println);
        controller.findHotelByName("Hotel26").forEach(System.out::println);

        Map<String, String> params = new HashMap<>();
        params.put("hotel","hotel2");
        params.put("price","100");
        List<Room> foundRooms = controller.findRoom(params);

        params.clear();
        params.put("city","kiev");
        params.put("price","100");
        foundRooms = controller.findRoom(params);

        System.out.println();
       controller.bookRoom(1,1,1);
        System.out.println();
        controller.bookRoom(2,23,121);
        System.out.println();
        controller.bookRoom(1,13,1);
        System.out.println();
/*        controller.cancelReservation(1,1,1);
        System.out.println();
        controller.cancelReservation(32,1,1);
        System.out.println();
        controller.cancelReservation(32,1,23);
        System.out.println();
        controller.cancelReservation(1,13,1);*/
    }
}
