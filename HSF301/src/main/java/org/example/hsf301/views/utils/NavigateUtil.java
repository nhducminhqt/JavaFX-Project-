package org.example.hsf301.views.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class NavigateUtil {


    public static void navigateTo(String fxmlResource,
                                  Node sourceNode,
                                  Integer width,
                                  Integer height,
                                  String title) {
        try {
            // Load the new layout
            FXMLLoader loader = new FXMLLoader(NavigateUtil.class.getResource(fxmlResource));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage currentStage = (Stage) sourceNode.getScene().getWindow();
            currentStage.close();

            // Set up the new stage
            Stage newStage = new Stage();

            // Set default values for height and width if not provided
            double sceneHeight = (height != null) ? height : 800;  // Default width
            double sceneWidth = (width != null) ? width : 600; // Default height

            Scene scene = new Scene(root, sceneWidth, sceneHeight);
            newStage.setScene(scene);

            // Set the title, default to "Application Title" if not specified
            newStage.setTitle((title != null) ? title : "Application Title");

            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            AppAlert.showAlert("Error", "Failed to load the specified layout.");
        }
    }

}
