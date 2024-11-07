package org.example.hsf301.controllers;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.service.IBookingService;

@RequiredArgsConstructor
public class BookingController implements Initializable {

    private final IBookingService bookingService;

    @FXML
    private GridPane bookingGrid;

    private static final int COLUMNS = 3; // Adjust number of columns for booking display

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayBookings(LoginController.account); // Load and display bookings for user 'minh1'
    }

    private void displayBookings(Account account) {
        // Retrieve the list of bookings by account ID
        List<Bookings> bookings = bookingService.findByAccountID(account.getUsername());
        int row = 0;
        int col = 0;

        for (Bookings booking : bookings) {
            VBox bookingCard = createBookingCard(booking);
            bookingGrid.add(bookingCard, col, row);

            col++;
            if (col == COLUMNS) {
                col = 0;
                row++;
            }
        }
    }

    private VBox createBookingCard(Bookings booking) {
        VBox card = new VBox(10);
        card.setMaxWidth(350);
        card.setPrefWidth(350);
        card.setStyle("-fx-background-color: white; " +
                          "-fx-border-color: #e0e0e0; " +
                          "-fx-border-radius: 8; " +
                          "-fx-background-radius: 8; " +
                          "-fx-padding: 15; " +
                          "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0);");

        // Booking Type
        Label typeLabel = new Label("Booking Type: " + booking.getBookingType());
        typeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        typeLabel.setWrapText(true);

        // Booking Date
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Label dateLabel = new Label("Date: " + booking.getBookingDate().format(dateFormatter));
        dateLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #7f8c8d;");

        // Payment Information
        HBox paymentInfoBox = new HBox(15);
        paymentInfoBox.setAlignment(Pos.CENTER_LEFT);

        Label paymentStatusLabel = new Label("Payment Status: " + booking.getPaymentStatus());
        paymentStatusLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");

        Label amountLabel = new Label("Total: $" + booking.getTotalAmountWithVAT());
        amountLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");

        paymentInfoBox.getChildren().addAll(paymentStatusLabel, amountLabel);

        // Payment Method
        Label paymentMethodLabel = new Label("Payment Method: " + booking.getPaymentMethod());
        paymentMethodLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");

        // Add all elements to card
        card.getChildren().addAll(
            typeLabel,
            dateLabel,
            paymentInfoBox,
            paymentMethodLabel
        );

        return card;
    }
}
