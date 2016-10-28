package bookingsystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import bookingsystem.model.*;

public class AbstractDAOImpl<T extends BaseEntity> implements AbstractDAO<T> {
    private List<T> objectList;

    public AbstractDAOImpl() {
        this.objectList = new ArrayList<T>();
    }

    @Override
    public T save(T o) {
        if (!objectList.contains(o))
            objectList.add(o);
        else
            objectList.set(objectList.indexOf(o),o);

        return o;
    }

    @Override
    public void delete(T o) {
        objectList.removeIf(o2 -> o2.equals(o));
    }

    @Override
    public void deleteAll(List<T> list) {
        for(T o : list)
            delete(o);
    }

    @Override
    public void saveAll(List<T> list) {
        for(T o : list)
            save(o);
    }

    @Override
    public void deleteById(long id) {
        objectList.removeIf(o2 -> o2.getId() == id);
    }

    @Override
    public T findById(long id) {
        Optional<T> res = objectList.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
        if (res.isPresent()) {
            return res.get();
        }
        else
            return null;
    }

    @Override
    public List<T> getList() {
        return objectList;
    }

    @Override
    public String toString() {
        return "AbstractDAOImpl{" +
                "objectList=" + objectList +
                '}';
    }
}
