package org.example.hsf301.dao;


import org.example.hsf301.pojo.DeliveryHistory;

import java.util.List;

public interface IDeliveryHistoryDAO {
    public List<DeliveryHistory> getAll();

    public void save(DeliveryHistory student);

    public void delete(Long studentID);

    public DeliveryHistory findById(Long studentID);

    public void update(DeliveryHistory student);
}
