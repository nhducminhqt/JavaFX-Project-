package org.example.hsf301.repo;

import org.example.hsf301.pojo.Delivery;

import java.util.List;

public interface IDeliveryRepository {
    List<Delivery> getAll();

    void save(Delivery student);

    void delete(Long studentID);

    Delivery findById(Long studentID);

    void update(Delivery student);


}
