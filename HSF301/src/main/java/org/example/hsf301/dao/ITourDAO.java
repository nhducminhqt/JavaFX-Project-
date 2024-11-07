package org.example.hsf301.dao;

import java.util.List;
import org.example.hsf301.pojo.Tours;

public interface ITourDAO {

    void save(Tours tours);
    List<Tours> findAll();
    void delete(Long id);
    Tours findById(Long id);
    void update(Tours tours);
    List<Tours> findByTourName(String tourName);
    List<Tours> findByTourActive();

}
