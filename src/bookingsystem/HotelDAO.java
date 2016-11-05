package bookingsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class HotelDAO implements AbstractDAO<Hotel> {

    static List<Hotel> hotels = new ArrayList<>();
    static List<Room> hotel1rooms = new LinkedList<>();
    static List<Room> hotel2rooms = new LinkedList<>();
    static List<Room> hotel3rooms = new LinkedList<>();

    static {

        hotels.add(new Hotel(1, "PlazaHotel", "Kiev", 1, hotel1rooms));
        hotels.add(new Hotel(2, "GrandHotel", "New York", 2, hotel2rooms));
        hotels.add(new Hotel(3, "PrimeHotel", "Kiev", 1, hotel3rooms));

        hotel1rooms.add(new Room(1, 100, 4, hotels.get(0).getName(),hotels.get(0).getCity()));
        hotel1rooms.add(new Room(2, 200, 2, hotels.get(0).getName(),hotels.get(0).getCity()));
        hotel1rooms.add(new Room(3, 300, 3, hotels.get(0).getName(),hotels.get(0).getCity()));

        hotel2rooms.add(new Room(1, 100, 4, hotels.get(1).getName(),hotels.get(1).getCity()));
        hotel2rooms.add(new Room(2, 200, 2, hotels.get(1).getName(),hotels.get(1).getCity()));
        hotel2rooms.add(new Room(3, 300, 3, hotels.get(1).getName(),hotels.get(1).getCity()));

        hotel3rooms.add(new Room(1, 100, 4, hotels.get(2).getName(),hotels.get(2).getCity()));
        hotel3rooms.add(new Room(2, 200, 2, hotels.get(2).getName(),hotels.get(2).getCity()));
        hotel3rooms.add(new Room(3, 300, 3, hotels.get(2).getName(),hotels.get(2).getCity()));
    }

    @Override
    public Hotel save(Hotel hotel) {
        this.hotels.add(hotel);
        return hotel;
    }

    @Override
    public void delete(Hotel hotel) {
        this.hotels.remove(hotel);
    }

    @Override
    public void deleteAll(List<Hotel> hotels) {
        this.hotels.removeAll(hotels);
    }

    @Override
    public void saveAll(List<Hotel> hotels) {
        this.hotels.addAll(hotels);
    }

    @Override
    public List<Hotel> getAlll() {
        return this.hotels;
    }

    @Override
    public void deleteById(long id) {
        this.hotels.remove(id);
    }

    @Override
    public Hotel findById(int id) {
        return this.hotels.get(id);
    }
}
