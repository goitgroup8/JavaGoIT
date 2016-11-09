package bookingsystem.model;

public class Room extends BaseEntity{

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

    public Room(long id, int price, int persons, User userReserved) {
        super(id);
        this.price = price;
        this.persons = persons;
        this.userReserved = userReserved;
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
    public String toString() {
        return "Room{" +
                "id=" + getId() +
                ", price=" + price +
                ", persons=" + persons +
                ", userReserved=" + userReserved +
                ", hotel=" + getHotelName() +
                ", city=" + getCityName() +
                '}';
    }
}
