package org.example.hsf301.service;

import org.example.hsf301.model.request.DepositRequest;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.Deposit;
import org.example.hsf301.repo.BookingRepository;
import org.example.hsf301.repo.DepositRepository;
import org.example.hsf301.repo.IBookingRepository;
import org.example.hsf301.repo.IDepositRepository;

import java.time.LocalDateTime;

public class DepositService implements IDepositService{
    private IBookingRepository bookingRepo;
    private IDepositRepository depositRepo;
    public DepositService(String name){
        bookingRepo = new BookingRepository(name);
        depositRepo = new DepositRepository(name);
    }
    @Override
    public Deposit getDepositByBookingId(Long bookingId) {
        return depositRepo.findByBookingId(bookingId);
    }

    @Override
    public Deposit createDeposit(DepositRequest depositRequest, Long bookingId) {
        Deposit deposit = new Deposit();
        Bookings bookings = bookingRepo.findById(bookingId);
        if(bookings == null){return null;}
        deposit.setBooking(bookings);
        deposit.setDepositStatus("complete");
        deposit.setDepositPercentage(depositRequest.getDepositPercentage());
        deposit.setShippingFee(depositRequest.getShippingFee());
        deposit.setShippingAddress(depositRequest.getShippingAddress());
        deposit.setDeliveryExpectedDate(depositRequest.getDeliveryExpectedDate());
        deposit.setDepositDate(LocalDateTime.now());
        deposit.setDepositAmount(bookings.getTotalAmountWithVAT()*depositRequest.getDepositPercentage());
        deposit.setRemainAmount(bookings.getTotalAmountWithVAT()-deposit.getDepositAmount()+deposit.getShippingFee());
        depositRepo.save(deposit);
        return deposit;
    }

    @Override
    public Deposit deleteById(Long id) {
        Deposit deposit = depositRepo.findById(id);
        deposit.setDepositStatus("cancel");
        depositRepo.update(deposit);
        return deposit;
    }

    @Override
    public Deposit updateDeposit(Long id, DepositRequest depositRequest) {
        Deposit deposit = depositRepo.findById(id);
        if(deposit == null){return null;}
        deposit.setDeliveryExpectedDate(depositRequest.getDeliveryExpectedDate());

        deposit.setShippingAddress(depositRequest.getShippingAddress());

        deposit.setShippingFee(depositRequest.getShippingFee());

        deposit.setDepositPercentage(depositRequest.getDepositPercentage());

        deposit.setDepositAmount(depositRequest.getDepositPercentage()*deposit.getBooking().getTotalAmountWithVAT());

        deposit.setRemainAmount(deposit.getBooking().getTotalAmountWithVAT()-deposit.getDepositAmount()+deposit.getShippingFee());
        depositRepo.update(deposit);
        return deposit;
    }
}
