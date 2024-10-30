package org.example.hsf301.layouts;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.controllers.TourController;
import org.example.hsf301.service.TourService;
import org.example.hsf301.views.utils.NavigateUtil;

public class MainController implements Initializable {

    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Set tours_home_page as the default content when the app starts
            setContent("tours_home_page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handler for navigating to the Home page
    @FXML
    private void navigateHome() throws IOException {
        setContent("home");
    }

    // Handler for navigating to the Tours page
    @FXML
    private void navigateTours() throws IOException {
        setContent("tours");
    }

    // Handler for navigating to the Bookings page
    @FXML
    private void navigateBookings() throws IOException {
        setContent("bookings");
    }

    // Handler for navigating to the Settings page
    @FXML
    private void navigateSettings() throws IOException {
        setContent("settings");
    }

    @FXML
    private void navigateLogout() throws IOException {
        NavigateUtil.navigateTo("/org/example/hsf301/fxml/login.fxml", contentArea, 830, 650, "Hello!");
    }

    // Method to dynamically load and set content in the content area
    private void setContent(String page) throws IOException {
        // Load the corresponding FXML for the page
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/hsf301/fxml/" + page + ".fxml")));

        // Check if specific controller is needed (like TourController)
        if (page.equals("tours_home_page")) {
            TourService tourService = new TourService(ResourcePaths.HIBERNATE_CONFIG);
            TourController tourController = new TourController(tourService);
            loader.setController(tourController);
        }

        // Load the FXML file and set the content
        Node pageContent = loader.load();
        contentArea.getChildren().clear();
        contentArea.getChildren().add(pageContent);
    }
}

