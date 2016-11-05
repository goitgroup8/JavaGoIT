package bookingsystem;

import bookingsystem.model.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.findHotelByCity("Kiev").forEach(System.out::println);
        System.out.println();
        controller.findHotelByName("PlazaHotel").forEach(System.out::println);
    }
}
