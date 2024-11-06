package org.example.hsf301.dao;

import java.util.List;
import org.example.hsf301.pojo.Tours;

public interface ITourDAO {

    public void save(Tours tours);
    public List<Tours> findAll();
    public void delete(Long id);
    public Tours findById(Long id);
    public void update(Tours tours);
    public List<Tours> findByTourName(String tourName);
    public List<Tours> findByTourActive();

}
