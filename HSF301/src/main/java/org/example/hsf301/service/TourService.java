package org.example.hsf301.service;

import java.util.List;
import org.example.hsf301.pojo.Tours;
import org.example.hsf301.repo.ITourRepository;
import org.example.hsf301.repo.TourRepository;

public class TourService implements ITourService{

    private final ITourRepository tourRepo;

    public TourService(String jpaName){
        tourRepo = new TourRepository(jpaName);
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
