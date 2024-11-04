package org.example.hsf301.repo;

import org.example.hsf301.pojo.Delivery;

import java.util.List;

public interface IDeliveryRepository {
    public List<Delivery> getAll();

    public void save(Delivery student);

    public void delete(Long studentID);

    public Delivery findById(Long studentID);

    public void update(Delivery student);


}
