package org.example.hsf301.navigate;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.controllers.LoginController;
import org.example.hsf301.controllers.TourController;
import org.example.hsf301.service.AccountService;
import org.example.hsf301.service.TourService;
import org.example.hsf301.utils.NavigateUtil;

public interface Navigable {

    // Default method to navigate to the Home page
    default void navigateHome(StackPane contentArea) throws IOException {
        setContent("home", contentArea);
    }

    // Default method to navigate to the Tours page
    default void navigateTours(StackPane contentArea) throws IOException {
        setContent("tours", contentArea);
    }

    // Default method to navigate to the Bookings page
    default void navigateBookings(StackPane contentArea) throws IOException {
        setContent("bookings", contentArea);
    }

    // Default method to navigate to the Settings page
    default void navigateSettings(StackPane contentArea) throws IOException {
        setContent("settings", contentArea);
    }

    default void navigateLogout(StackPane contentArea) throws IOException {
        NavigateUtil.navigateTo(ResourcePaths.LOGIN_VIEW, contentArea, 830, 650, "Hello!");
    }

    // Method to load and set the content in the provided contentArea
    default void setContent(String page, StackPane contentArea) throws IOException {
        FXMLLoader loader = new FXMLLoader(
            Objects.requireNonNull(getClass().getResource("/org/example/hsf301/fxml/" + page + ".fxml")));

        // preload on startup with initialize method
        //preload data when customer login
        if (page.equals("tours_home_page")) {
            TourService tourService = new TourService(ResourcePaths.HIBERNATE_CONFIG);
            TourController tourController = new TourController(tourService);
            loader.setController(tourController);
        }

        //preload data when admin login


        //preload data when staff login

        Node pageContent = loader.load();
        contentArea.getChildren().clear();
        contentArea.getChildren().add(pageContent);
    }
}
