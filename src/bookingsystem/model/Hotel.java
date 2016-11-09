package bookingsystem.model;

import java.util.List;

public class Hotel extends BaseEntity {

    private String name;
    private String city;
    private long rating;
    private List<Room> rooms;

    public Hotel(long id, String name, String city, long rating) {
        super(id);
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                '}';
    }
}
