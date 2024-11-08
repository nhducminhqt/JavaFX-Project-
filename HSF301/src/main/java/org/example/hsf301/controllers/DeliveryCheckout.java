package org.example.hsf301.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.enums.CCSTATUS;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.Delivery;
import org.example.hsf301.service.DeliveryService;
import org.example.hsf301.service.IDeliveryService;

import java.net.URL;
import java.util.ResourceBundle;

public class DeliveryCheckout implements Initializable {
    @FXML
    private TextField txtCustomerName;
    @FXML
    private DatePicker deliveryDatePicker;
    @FXML
    private TextField txtremain;
    @FXML
    private TextField txtdeliverystaff;
    @FXML
    private TextField txtpayment;
    @FXML
    private TextArea txtreason;
    @FXML
    private TextArea txtaddress;
    @FXML
    private TextArea txtdescription;
    private Bookings bookings;
    private IDeliveryService deliveryService;
    public DeliveryCheckout() {
        deliveryService = new DeliveryService(ResourcePaths.HIBERNATE_CONFIG);
    }

    @FXML
    public void confirmOrder() {
        Stage stage = (Stage)  txtaddress.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public Bookings getBookings() {
        return bookings;
    }

    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
        show(bookings);
    }
    private void show(Bookings bookings) {
        Delivery delivery = bookings.getDelivery();
        if(delivery==null){
            throw new IllegalArgumentException("This booking does not have a delivery");
        }
        txtaddress.setText(delivery.getAddress());
        txtdescription.setText(delivery.getHealthKoiDescription());
        deliveryDatePicker.setValue(delivery.getReceiveDate());
        txtCustomerName.setText(delivery.getCustomerName());
        txtremain.setText(String.valueOf(delivery.getRemainAmount()));
        txtdeliverystaff.setText(delivery.getDeliveryStaff().getUsername());
        txtpayment.setText(String.valueOf(delivery.getStatus()));
        txtreason.setText(delivery.getReason());
    }
}
