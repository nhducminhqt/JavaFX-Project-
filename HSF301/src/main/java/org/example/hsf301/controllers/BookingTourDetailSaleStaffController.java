package org.example.hsf301.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.Data;
import org.example.hsf301.pojo.BookingKoiDetail;
import org.example.hsf301.pojo.BookingTourDetail;
import org.example.hsf301.service.IBookingKoiDetailService;
import org.example.hsf301.service.IBookingTourDetailService;
import org.example.hsf301.service.IKoiFarmService;
import org.example.hsf301.service.IKoiOfFarmService;


@Data

public class BookingTourDetailSaleStaffController {
    private Long bookingId;
    @FXML
    private TableView<BookingTourDetail> tblBookingTour;
    @FXML
    private TableColumn<BookingKoiDetail, Long> id;
    @FXML
    private TableColumn<BookingKoiDetail, Long> participant;
    @FXML
    private TableColumn<BookingKoiDetail, Float> totalamount;
    @FXML
    private TableColumn<BookingKoiDetail, Long> bookingid;
    @FXML
    private TableColumn<BookingKoiDetail, Long> tourid;
    private ObservableList<BookingTourDetail> tableModel;
    private IBookingTourDetailService bookingTourDetailService;


    public void loadData() {
        if (bookingId != null) {
            tableModel.setAll(bookingTourDetailService.getBookingTourDetail(bookingId));
            tblBookingTour.setItems(tableModel);
        }
    }

}
