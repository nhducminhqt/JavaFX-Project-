package org.example.hsf301.repo;

import org.example.hsf301.pojo.TourDetail;


import java.util.List;

public interface ITourDetailRepository {
    void save(TourDetail tourDetail);
    List<TourDetail> findAll();
    void delete(Long id);
    TourDetail findById(Long id);
    void update(TourDetail tourDetail);
}
