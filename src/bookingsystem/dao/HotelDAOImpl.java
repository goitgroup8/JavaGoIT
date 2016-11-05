package bookingsystem.dao;

import bookingsystem.model.Hotel;
import bookingsystem.model.Room;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HotelDAOImpl extends AbstractDAOImpl<Hotel> {

    @Override
    public Hotel save(Hotel o) {
        return super.save(o);
    }

    @Override
    public void delete(Hotel o) {
        super.delete(o);
    }

    @Override
    public void deleteAll(List<Hotel> o) {
        super.deleteAll(o);
    }

    @Override
    public void saveAll(List<Hotel> o) {
        super.saveAll(o);
    }

    @Override
    public List<Hotel> getAlll() {
        return super.getAlll();
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
    }

    @Override
    public Hotel findById(int id) {
        return super.findById(id);
    }

}
