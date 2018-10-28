package pl.sdacademy.servlet;

import java.util.List;


public interface CatRepository {

    void save(Cat cat);
    List<Cat> findAll();
    List<Cat> findByRace(String race);
    List<Cat> findByName(String name);
    List<Cat> findByOwner(String owner);
}
