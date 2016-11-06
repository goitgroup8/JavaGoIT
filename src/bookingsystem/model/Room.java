package bookingsystem.model;

public class Room extends BaseEntity{
    private long id;
    private int price;
    private int persons;
    private String hotelName;
    private String cityName;
    private User userReserved;

    public User getUserReserved() {
        return userReserved;
    }

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }


    public Room(long id, int price, int persons, String hotelName, String cityName, User userReserved) {
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.hotelName = hotelName;
        this.cityName = cityName;
        this.userReserved = userReserved;
    }

    @Override
    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getPersons() {
        return persons;
    }


    public String getHotelName() {
        return hotelName;
    }

    public String getCityName() {
        return cityName;
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


    public Room setHotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public Room setCityName(String cityName) {
        this.cityName = cityName;
        return this;
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

        result = 31 * result + hotelName.hashCode();
        result = 31 * result + cityName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", persons=" + persons +
                ", hotelName='" + hotelName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", userReserved=" + userReserved +
                '}';
    }
}
