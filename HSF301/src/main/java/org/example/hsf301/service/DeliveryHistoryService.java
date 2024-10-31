package org.example.hsf301.service;

import org.example.hsf301.model.request.DeliveryHistoryRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.DeliveryHistory;
import org.example.hsf301.repo.BookingRepository;
import org.example.hsf301.repo.DeliveryHistoryRepository;
import org.example.hsf301.repo.IBookingRepository;
import org.example.hsf301.repo.IDeliveryHistoryRepository;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryHistoryService implements IDeliveryHistoryService {
    private IDeliveryHistoryRepository deliveryHistoryRepo;
    private IBookingRepository bookingRepo;
    private Account account;

    public DeliveryHistoryService(String name,Account account) {
        deliveryHistoryRepo = new DeliveryHistoryRepository(name);
        bookingRepo = new BookingRepository(name);
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
