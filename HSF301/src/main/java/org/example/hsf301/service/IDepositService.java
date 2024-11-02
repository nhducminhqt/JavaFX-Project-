package org.example.hsf301.service;

import org.example.hsf301.model.request.DepositRequest;
import org.example.hsf301.pojo.Deposit;

import java.util.List;

public interface IDepositService {
    Deposit getDepositByBookingId(Long bookingId);

    Deposit createDeposit(DepositRequest depositRequest, Long bookingId);

    Deposit deleteById(Long id);

    Deposit updateDeposit(Long id, DepositRequest depositRequest);


}
