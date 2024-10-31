package org.example.hsf301.service;

import java.util.List;
import org.example.hsf301.pojo.Tours;
import org.example.hsf301.repo.ITourRepo;
import org.example.hsf301.repo.TourRepo;

public class TourService implements ITourService{

    private final ITourRepo tourRepo;

    public TourService(String jpaName){
        tourRepo = new TourRepo(jpaName);
    }

    @Override
    public void save(Tours tours) {
        tourRepo.save(tours);
    }

    @Override
    public List<Tours> findAll() {
        return tourRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        tourRepo.delete(id);
    }

    @Override
    public Tours findById(Integer id) {
        return tourRepo.findById(id);
    }
}
