package edu.kosa.service;

import java.util.List;

public interface CRUDService {
    // 쓰기, 리스트, 읽기, 수정, 삭제, 조회수 증가, 글의 개수

    boolean create(Object object);

    boolean reply(Object object);

    boolean updateSort(Object object);

    boolean hit(Object object);

    Object read(Object object);

    List readAll(Object object);

    int count();

    boolean update(Object object);

    boolean delete(Object object);
}
