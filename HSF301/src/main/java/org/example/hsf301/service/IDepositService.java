package org.example.hsf301.service;

import org.example.hsf301.model.request.DepositRequest;
import org.example.hsf301.pojo.Deposit;

import java.util.List;

public interface IDepositService {
    Deposit getDepositByBookingId(Long bookingId);

    void createDeposit(DepositRequest depositRequest, Long bookingId);

    void deleteById(Long id);

    void updateDeposit(Long id, DepositRequest depositRequest);

    List<Deposit> getAllDeposits();

    Deposit getDepositById(Long id);


}
