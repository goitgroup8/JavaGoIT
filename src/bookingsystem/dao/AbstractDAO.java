package bookingsystem.dao;

import java.util.List;

public interface AbstractDAO <T> {
    T save(T o);

    void delete(T o);

    void deleteAll(List<T> o);

    void saveAll(List<T> o);

    List<T> getList();

    void deleteById(long id);

    T findById(long id);
}

