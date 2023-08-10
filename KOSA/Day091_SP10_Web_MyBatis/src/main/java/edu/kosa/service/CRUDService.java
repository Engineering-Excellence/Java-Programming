package edu.kosa.service;

import java.util.List;

public interface CRUDService {

    Object select(Object object);

    List selectAll();

    boolean insert(Object object);

    boolean update(Object object);

    boolean delete(Object object);

    default List search(Object object) {
        return null;
    }
}
