package bookingsystem.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerTest {

    Controller controller = new Controller();
    User user = new User(1, "Artur", "Kovalchuk");
    User user1 = new User(2, "Oleg", "Green");
    User user2 = new User(3, "Ivan", "Toropov");
    User user3 = new User(4, "Joker", "Joker");
    {
        controller.registerUser(user);
        controller.registerUser(user1);
        controller.registerUser(user2);
        controller.curUser.setCurUser(user);
    }

    @Test
    public void findHotelByNameKiev() throws Exception {
        List<Hotel> foundRoom  = controller.findHotelByCity("Kiev");
        List<Hotel> foundRooms = new ArrayList<>();
        foundRooms.add(new Hotel(1, "Hotel1", "Kiev", 1));
        foundRooms.add(new Hotel(2, "Hotel2", "Kiev", 3));
        assertEquals(foundRoom, foundRooms);
    }

    @Test
    public void findHotelByNameAmsterdam() throws Exception {
        List<Hotel> foundRoom  = controller.findHotelByCity("Amsterdam");
        List<Hotel> foundRooms = new ArrayList<>();
        foundRooms.add(new Hotel(5, "Hotel5", "Amsterdam", 3));
        foundRooms.add(new Hotel(6, "Hotel6", "Amsterdam",4));
        assertEquals(foundRoom, foundRooms);
    }

    @Test
    public void findHotelByNameNotNull() throws Exception {
        List<Hotel> foundRoom  = controller.findHotelByCity(null);
        assertNotNull(foundRoom);
    }

    @Test
    public void findHotelByNameNull() throws Exception {
        List<Hotel> foundRoom  = controller.findHotelByCity(null);
        assertNull(foundRoom);
    }

    @Test
    public void findHotelByCityNull() throws Exception {
        List<Hotel> foundRoom  = controller.findHotelByCity(null);
        assertNull(foundRoom);
    }
    @Test
    public void findHotelByCity() throws Exception {
        List<Hotel> foundRoom  = controller.findHotelByCity("");
        assertEquals(foundRoom, new ArrayList<>());
    }

    @Test
    public void bookRoom() throws Exception {

    }

    @Test
    public void cancelReservation() throws Exception {

    }

    @Test
    public void findRoom() throws Exception {

    }

    @Test
    public void registerUser() throws Exception {

    }

}