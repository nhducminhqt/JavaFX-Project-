package org.example.hsf301.controllers.management;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.example.hsf301.pojo.KoiFarms;
import org.example.hsf301.pojo.Tours;
import org.example.hsf301.service.IKoiFarmService;
import org.example.hsf301.utils.AppAlert;

@RequiredArgsConstructor
public class FarmManagementController implements Initializable {

    @FXML
    private GridPane farmGrid;

    private final IKoiFarmService koiFarmService;
    private static final int COLUMNS = 4;
    private static final SimpleDateFormat DATE_FORMATTER =
        new SimpleDateFormat("MMM dd, yyyy HH:mm");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayTours();
    }

    private void displayTours() {
        List<KoiFarms> farms = koiFarmService.findAll();
        int row = 0;
        int col = 0;

        for (KoiFarms farm : farms) {
            VBox tourCard = createFarmCard(farm);
            farmGrid.add(tourCard, col, row);

            col++;
            if (col == COLUMNS) {
                col = 0;
                row++;
            }
        }
    }

    private VBox createFarmCard(KoiFarms farm) {
        VBox card = new VBox(10);
        card.setMaxWidth(350);
        card.setPrefWidth(350);
        card.setStyle("-fx-background-color: white; " +
                          "-fx-border-color: #e0e0e0; " +
                          "-fx-border-radius: 8; " +
                          "-fx-background-radius: 8; " +
                          "-fx-padding: 15; " +
                          "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0);");

        // Farm Image
        if (farm.getImage() != null && !farm.getImage().isEmpty()) {
            try {
                ImageView imageView = new ImageView(new Image(farm.getImage()));
                imageView.setFitWidth(320);
                imageView.setFitHeight(200);
                imageView.setPreserveRatio(true);
                card.getChildren().add(imageView);
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
            }
        }

        // Farm Name
        Label nameLabel = new Label(farm.getFarmName());
        nameLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        nameLabel.setWrapText(true);

        // Contact Information
        VBox contactBox = new VBox(5);
        contactBox.setStyle("-fx-padding: 10 0;");

        // Phone and Email
        HBox contactDetailsBox = new HBox(15);
        contactDetailsBox.setAlignment(Pos.CENTER_LEFT);

        Label phoneLabel = new Label("📞 " + farm.getFarmPhoneNumber());
        phoneLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #7f8c8d;");

        Label emailLabel = new Label("✉ " + farm.getFarmEmail());
        emailLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #7f8c8d;");

        contactDetailsBox.getChildren().addAll(phoneLabel, emailLabel);

        // Address
        Label addressLabel = new Label("📍 " + farm.getFarmAddress());
        addressLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #7f8c8d;");
        addressLabel.setWrapText(true);

        // Website
        Hyperlink websiteLink = new Hyperlink(farm.getWebsite());
        websiteLink.setStyle("-fx-font-size: 13px; -fx-text-fill: #3498db;");
        websiteLink.setOnAction(e -> {
            // TODO: Implement website opening logic
            System.out.println("Opening website: " + farm.getWebsite());
        });

        contactBox.getChildren().addAll(contactDetailsBox, addressLabel, websiteLink);

        // Description
        Label descriptionLabel = new Label(farm.getDescription());
        descriptionLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");
        descriptionLabel.setWrapText(true);

        // View Details Button
        Button viewDetailsButton = new Button("View Farm Details");
        viewDetailsButton.setMaxWidth(Double.MAX_VALUE);
        viewDetailsButton.setStyle("-fx-background-color: #2ecc71; " +
                                       "-fx-text-fill: white; " +
                                       "-fx-font-size: 14px; " +
                                       "-fx-padding: 10 20; " +
                                       "-fx-cursor: hand; " +
                                       "-fx-background-radius: 5;");

        // CRUD Buttons
        HBox crudButtons = new HBox(5);
        crudButtons.setAlignment(Pos.CENTER);

        Button editButton = createStyledButton("Edit", "#f39c12");
        Button deleteButton = createStyledButton("Delete", "#e74c3c");
        Button viewButton = createStyledButton("View", "#3498db");

        editButton.setOnAction(event -> handleEdit(farm));
        deleteButton.setOnAction(event -> handleDelete(farm));
        viewButton.setOnAction(event -> handleView(farm));

        crudButtons.getChildren().addAll(viewButton, editButton, deleteButton);

        viewDetailsButton.setOnAction(event -> handleViewDetails(farm));

        // Add all elements to card
        card.getChildren().addAll(
            nameLabel,
            contactBox,
            descriptionLabel,
            viewDetailsButton,
            crudButtons
        );

        return card;
    }

    private Button createStyledButton(String text, String color) {
        Button button = new Button(text);
        button.setStyle(
            String.format("-fx-background-color: %s; " +
                              "-fx-text-fill: white; " +
                              "-fx-font-size: 12px; " +
                              "-fx-padding: 5 10; " +
                              "-fx-cursor: hand; " +
                              "-fx-background-radius: 3;", color)
        );
        return button;
    }

    private void handleBooking(KoiFarms koiFarms) {
        System.out.println("Booking tour: " + koiFarms.getFarmName());
    }

    private void handleEdit(KoiFarms koiFarms) {
        System.out.println("Editing koiFarms: " + koiFarms.getFarmName());
        // TODO: Implement edit logic
    }

    private void handleDelete(KoiFarms koiFarms) {
        koiFarmService.delete(koiFarms.getId());
        AppAlert.showAlert("Success", "Tour deleted successfully");
    }

    private void handleView(KoiFarms koiFarms) {
        System.out.println("Viewing koiFarms: " + koiFarms.getFarmName());
        // TODO: Implement view logic
    }

    private void handleViewDetails(KoiFarms farm) {
        // TODO: Implement view details logic
        System.out.println("Viewing details for farm: " + farm.getFarmName());
        // Add navigation logic to detailed view
    }
}