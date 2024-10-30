package org.example.hsf301.service;

import org.example.hsf301.model.request.DeliveryHistoryRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.DeliveryHistory;
import org.example.hsf301.repo.BookingRepo;
import org.example.hsf301.repo.DeliveryHistoryRepo;
import org.example.hsf301.repo.IBookingRepo;
import org.example.hsf301.repo.IDeliveryHistoryRepo;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryHistoryService implements IDeliveryHistoryService {
    private IDeliveryHistoryRepo deliveryHistoryRepo;
    private IBookingRepo bookingRepo;
    private Account account;

    public DeliveryHistoryService(String name,Account account) {
        deliveryHistoryRepo = new DeliveryHistoryRepo(name);
        bookingRepo = new BookingRepo(name);
        this.account = account;
    }
    @Override
    public DeliveryHistory addDeliveryHistory(DeliveryHistoryRequest deliveryHistoryRequest, Long bookingId) throws Exception {
        Bookings bookings = bookingRepo.findById(bookingId);
        if(bookings == null){return null;}
        if(!bookings.getPaymentStatus().equals("shipping"))return null;
        DeliveryHistory deliveryHistory = new DeliveryHistory();
        deliveryHistory.setDeliveryStaff(account);
        deliveryHistory.setBooking(bookings);
        deliveryHistory.setRoute(deliveryHistoryRequest.getRoute());
        deliveryHistory.setHealthKoiDescription(deliveryHistoryRequest.getHealthKoiDescription());
        deliveryHistory.setCreatedDate(LocalDateTime.now());
        deliveryHistoryRepo.save(deliveryHistory);
        return deliveryHistory;
    }

    @Override
    public DeliveryHistory updateDeliveryHistory(Long deliveryHistoryId, DeliveryHistoryRequest deliveryHistoryRequest) throws Exception {
        DeliveryHistory deliveryHistory = deliveryHistoryRepo.findById(deliveryHistoryId);
        if(deliveryHistory == null){return null;}
        deliveryHistory.setRoute(deliveryHistoryRequest.getRoute());
        deliveryHistory.setHealthKoiDescription(deliveryHistoryRequest.getHealthKoiDescription());
        deliveryHistoryRepo.update(deliveryHistory);
        return deliveryHistory;
    }

    @Override
    public void deleteDeliveryHistory(Long deliveryHistoryId) {
        deliveryHistoryRepo.delete(deliveryHistoryId);
    }

    @Override
    public List<DeliveryHistory> getDeliveryHistory(Long bookingId) {
        return deliveryHistoryRepo.getAll();
    }
}
