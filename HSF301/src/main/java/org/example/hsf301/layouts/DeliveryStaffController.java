package org.example.hsf301.layouts;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import org.example.hsf301.navigate.Navigable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeliveryStaffController implements Navigable, Initializable {
    @FXML
    private StackPane contentArea;
    @FXML
    private void navigateLogout() throws IOException {
        navigateLogout(contentArea);
    }

    @FXML
    private void btnTourListAction() throws IOException {
        navigateBookingTourList(contentArea);
    }

    @FXML
    private void btnDepositAction() throws IOException {
            navigateDeposit(contentArea);
    }

    @FXML
    private void btnDeliveryAction() throws IOException {
        navigateDelivery(contentArea);
    }

    @FXML
    private void btnKoiListAction() throws IOException {
        navigateBookingKoiList(contentArea);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Set tours_home_page as the default content when the app starts
            setContent("BookingKoiListStaff", contentArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
