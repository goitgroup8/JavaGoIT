package bookingsystem.model;

public class Room extends BaseEntity{
    private long id;
    private int price;
    private int persons;
    private User userReserved;
    private Hotel hotel;

    User getUserReserved() {
        return userReserved;
    }

     void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }


     Room(long id, int price, int persons, User userReserved) {
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.userReserved = userReserved;
    }

    @Override
    public long getId() {
        return id;
    }

     int getPrice() {
        return price;
    }

     int getPersons() {
        return persons;
    }


    public String getHotelName() {
        return hotel.getName();
    }

    public String getCityName() {
        return hotel.getCity();
    }

    public Room setId(long id) {
        this.id = id;
        return this;
    }

    public Room setPrice(int price) {
        this.price = price;
        return this;
    }

    public Room setPersons(int persons) {
        this.persons = persons;
        return this;
    }




    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        return getId() == room.getId();

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + price;
        result = 31 * result + persons;

        result = 31 * result + hotel.getName().hashCode();
        result = 31 * result + hotel.getCity().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", persons=" + persons +
                ", hotelName='" + hotel.getName() + '\'' +
                ", cityName='" + hotel.getCity() + '\'' +
                ", userReserved=" + userReserved +
                '}';
    }
}
