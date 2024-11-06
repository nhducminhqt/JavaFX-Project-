package org.example.hsf301.dao;

import org.example.hsf301.pojo.TourDetail;
import org.example.hsf301.pojo.Tours;

import java.util.List;

public interface ITourDetailDAO {
    public void save(TourDetail tourDetail);
    public List<TourDetail> findAll();
    public void delete(Long id);
    public TourDetail findById(Long id);
    public void update(TourDetail tourDetail);

}
