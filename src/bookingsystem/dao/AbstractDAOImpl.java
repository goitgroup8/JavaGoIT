package bookingsystem.dao;

import bookingsystem.dao.AbstractDAO;
import bookingsystem.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class AbstractDAOImpl<T extends BaseEntity> implements AbstractDAO<T> {

    List<T> list = new ArrayList<T>();
    @Override
    public T save(T o) {
        this.list.add(o);
        return o;
    }

    @Override
    public void delete(T o) {
        this.list.remove(o);
    }

    @Override
    public void deleteAll(List<T> o) {
        this.list.removeAll(o);
    }

    @Override
    public void saveAll(List<T> o) {
        this.list.addAll(o);
    }

    @Override
    public List<T> getAlll() {
        return this.list;
    }

    @Override
    public void deleteById(long id) {
        list.remove(id);
    }

    @Override
    public T findById(int id) {
        for (T item : list) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }
}
