package org.example.hsf301.service;

import org.example.hsf301.model.request.DeliveryRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Delivery;

import java.util.List;

public interface IDeliveryService {
    Delivery addDelivery(DeliveryRequest deliveryRequest, Long bookingId, Account staff);

    Delivery updateDeliveryHistory(Long deliveryId, DeliveryRequest deliveryRequest) throws Exception;

    void deleteDelivery(Long deliveryId);

    Delivery getDelivery(Long deliveryId);

    List<Delivery> getAllDeliveries();
}
