package org.example.hsf301.layouts;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import org.example.hsf301.navigate.Navigable;
import org.example.hsf301.utils.NavigateUtil;

public class MainController implements Initializable, Navigable {

    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Set tours_home_page as the default content when the app starts
            setContent("tours_home_page", contentArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handler for navigating to the Home page
    @FXML
    private void navigateHome() throws IOException {
        navigateHome(contentArea);
    }

    // Handler for navigating to the Tours page
    @FXML
    private void navigateTours() throws IOException {
        navigateTours(contentArea);
    }

    // Handler for navigating to the Bookings page
    @FXML
    private void navigateBookings() throws IOException {
        navigateBookings(contentArea);
    }

    // Handler for navigating to the Settings page
    @FXML
    private void navigateSettings() throws IOException {
        navigateSettings(contentArea);
    }

    @FXML
    private void navigateLogout() throws IOException {
        navigateLogout(contentArea);
    }
}