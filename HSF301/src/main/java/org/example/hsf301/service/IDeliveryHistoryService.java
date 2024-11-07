package org.example.hsf301.service;

import org.example.hsf301.model.request.DeliveryHistoryRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.DeliveryHistory;

import java.util.List;

public interface IDeliveryHistoryService {
    DeliveryHistory addDeliveryHistory(DeliveryHistoryRequest deliveryHistoryRequest, Long bookingId, Account staff) throws Exception;

    DeliveryHistory updateDeliveryHistory(Long deliveryHistoryId,DeliveryHistoryRequest deliveryHistoryRequest) throws Exception;

    void deleteDeliveryHistory(Long deliveryHistoryId);

    List<DeliveryHistory> getDeliveryHistory(Long bookingId);

    DeliveryHistory getDeliveryHistoryById(Long deliveryHistoryId);
}
