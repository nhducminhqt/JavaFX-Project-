package org.example.hsf301.repo;

import java.util.List;
import org.example.hsf301.dao.ITourDAO;
import org.example.hsf301.dao.TourDAO;
import org.example.hsf301.pojo.Tours;

public class TourRepo implements ITourRepo{

    private ITourDAO tourDAO;

    public TourRepo(String jpaName){
        tourDAO = new TourDAO(jpaName);
    }

    @Override
    public void save(Tours tours) {
        tourDAO.save(tours);
    }

    @Override
    public List<Tours> findAll() {
        return tourDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
        tourDAO.delete(id);
    }

    @Override
    public Tours findById(Integer id) {
        return tourDAO.findById(id);
    }
}
