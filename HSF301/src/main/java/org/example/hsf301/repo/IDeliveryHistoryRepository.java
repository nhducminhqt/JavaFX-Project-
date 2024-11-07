package org.example.hsf301.repo;

import org.example.hsf301.pojo.DeliveryHistory;

import java.util.List;

public interface IDeliveryHistoryRepository {
    List<DeliveryHistory> getAll();

    void save(DeliveryHistory student);

    void delete(Long studentID);

    DeliveryHistory findById(Long studentID);

    void update(DeliveryHistory student);
}
