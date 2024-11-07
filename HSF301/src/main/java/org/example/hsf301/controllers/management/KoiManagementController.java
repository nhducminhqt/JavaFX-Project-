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
import org.example.hsf301.pojo.Koi;
import org.example.hsf301.pojo.KoiFarms;
import org.example.hsf301.service.IKoiService;
import org.example.hsf301.utils.AppAlert;

@RequiredArgsConstructor
public class KoiManagementController implements Initializable {

    @FXML
    private GridPane koiGrid;

    private final IKoiService koiService;
    private static final int COLUMNS = 4;
    private static final SimpleDateFormat DATE_FORMATTER =
        new SimpleDateFormat("MMM dd, yyyy HH:mm");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayTours();
    }

    private void displayTours() {
        List<Koi> kois = koiService.findAll();
        int row = 0;
        int col = 0;

        for (Koi koi : kois) {
            VBox tourCard = createKoiCard(koi);
            koiGrid.add(tourCard, col, row);

            col++;
            if (col == COLUMNS) {
                col = 0;
                row++;
            }
        }
    }

    private VBox createKoiCard(Koi koi) {
        VBox card = new VBox(10);
        card.setMaxWidth(300);
        card.setPrefWidth(300);
        card.setStyle("-fx-background-color: white; " +
                          "-fx-border-color: #e0e0e0; " +
                          "-fx-border-radius: 8; " +
                          "-fx-background-radius: 8; " +
                          "-fx-padding: 15; " +
                          "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0);");

        System.out.println("Koi data: " + koi);

        // Koi Image
        if (koi.getKoiImage() != null && !koi.getKoiImage().isEmpty()) {
            try {
                ImageView imageView = new ImageView();
                imageView.setImage(new Image(
                    Objects.requireNonNull(getClass().getResourceAsStream(koi.getKoiImage()))));
                imageView.setFitWidth(280);
                imageView.setFitHeight(180);
                imageView.setPreserveRatio(true);
                card.getChildren().add(imageView);
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
            }
        }

        // Koi Name
        Label nameLabel = new Label(koi.getKoiName());
        nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        nameLabel.setWrapText(true);

        // Origin and Color HBox
        HBox detailsBox = new HBox(10);
        detailsBox.setAlignment(Pos.CENTER_LEFT);

        Label originLabel = new Label("Origin: " + koi.getOrigin());
        originLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #7f8c8d;");

        Label colorLabel = new Label("Color: " + koi.getColor());
        colorLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #7f8c8d;");

        detailsBox.getChildren().addAll(originLabel, colorLabel);

        // Description
        Label descriptionLabel = new Label(koi.getDescription());
        descriptionLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");
        descriptionLabel.setWrapText(true);

        // View Details Button
        Button viewDetailsButton = new Button("View Details");
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

        editButton.setOnAction(event -> handleEdit(koi));
        deleteButton.setOnAction(event -> handleDelete(koi));
        viewButton.setOnAction(event -> handleView(koi));

        crudButtons.getChildren().addAll(viewButton, editButton, deleteButton);

        viewDetailsButton.setOnAction(event -> handleViewDetails(koi));

        // Add all elements to card
        card.getChildren().addAll(
            nameLabel,
            detailsBox,
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

    private void handleBooking(Koi koi) {
        System.out.println("Booking tour: " + koi.getKoiName());
    }

    private void handleEdit(Koi koi) {
        System.out.println("Editing koi: " + koi.getKoiName());
        // TODO: Implement edit logic
    }

    private void handleDelete(Koi koi) {
        koiService.delete(koi.getId());
        AppAlert.showAlert("Success", "Tour deleted successfully");
    }

    private void handleView(Koi koi) {
        System.out.println("Viewing koi: " + koi.getKoiName());
        // TODO: Implement view logic
    }

    private void handleViewDetails(Koi koi) {
        // TODO: Implement view details logic
        System.out.println("Viewing details for farm: " + koi.getKoiName());
        // Add navigation logic to detailed view
    }
}