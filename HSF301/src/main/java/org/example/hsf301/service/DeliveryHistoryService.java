package org.example.hsf301.service;

import org.example.hsf301.enums.PaymentStatus;
import org.example.hsf301.model.request.DeliveryHistoryRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.DeliveryHistory;
import org.example.hsf301.repo.BookingRepository;
import org.example.hsf301.repo.DeliveryHistoryRepository;
import org.example.hsf301.repo.IBookingRepository;
import org.example.hsf301.repo.IDeliveryHistoryRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DeliveryHistoryService implements IDeliveryHistoryService {
    private final IDeliveryHistoryRepository deliveryHistoryRepo;
    private final IBookingRepository bookingRepo;


    public DeliveryHistoryService(String name) {
        deliveryHistoryRepo = new DeliveryHistoryRepository(name);
        bookingRepo = new BookingRepository(name);

    }
    @Override
    public DeliveryHistory addDeliveryHistory(DeliveryHistoryRequest deliveryHistoryRequest, Long bookingId,Account staff) throws Exception {
        Bookings bookings = bookingRepo.findById(bookingId);
        if(bookings == null){return null;}
        if(!(bookings.getPaymentStatus()==PaymentStatus.SHIPPING))return null;
        DeliveryHistory deliveryHistory = new DeliveryHistory();
        deliveryHistory.setDeliveryStaff(staff);
        deliveryHistory.setBooking(bookings);
        deliveryHistory.setRoute(deliveryHistoryRequest.getRoute());
        deliveryHistory.setHealthKoiDescription(deliveryHistoryRequest.getHealthKoiDescription());
        deliveryHistory.setCreatedDate(LocalDate.now());
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
        List<DeliveryHistory> list = deliveryHistoryRepo.getAll();
        List<DeliveryHistory> result = new ArrayList<>();
        for(DeliveryHistory deliveryHistory : list){
            if(deliveryHistory.getBooking().getId().equals(bookingId)){
                result.add(deliveryHistory);
            }
        }
        return result;
    }

    @Override
    public DeliveryHistory getDeliveryHistoryById(Long deliveryHistoryId) {
        return deliveryHistoryRepo.findById(deliveryHistoryId);
    }
}
