package org.example.hsf301.controllers;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hsf301.constants.APIConstants;
import org.example.hsf301.exceptions.BadCredentialsException;
import org.example.hsf301.utils.ApiUtils;
import org.example.hsf301.views.utils.AppAlert;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignupController {

    @FXML
    public TextField usernameTextField;

    @FXML
    public TextField firstNameTextField;

    @FXML
    public TextField lastNameTextField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public PasswordField confirmPasswordField;

    @FXML
    public Button loginButton;


    public static String email = "";
    private String password = "";

    @FXML
    protected ImageView brandingImageView;
    @FXML
    protected ImageView logoImageView;

    @FXML
    public void initialize() {

        Image brandingImage = new Image(
            Objects.requireNonNull(
                    getClass().getResource("/org/example/hsf301/assets/img/branding.png"))
                .toExternalForm());
        brandingImageView.setImage(brandingImage);

        Image logoImage = new Image(
            Objects.requireNonNull(getClass().getResource("/org/example/hsf301/assets/img/koi.png"))
                .toExternalForm());
        logoImageView.setImage(logoImage);

        usernameTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                System.out.println("Enter key pressed");
                loginButtonAction(null);  // Trigger login action when Enter key is pressed
            }
        });
        passwordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                System.out.println("Enter key pressed");
                loginButtonAction(null);  // Trigger login action when Enter key is pressed
            }
        });
    }


    public void loginButtonAction(ActionEvent event) {
        if ((!usernameTextField.getText().isBlank()) && (!passwordField.getText().isBlank())) {
//            loginMessageLabel.setText("You tried to login");
            validateLogin();
        } else {
            AppAlert.IS_EMPTY_FIELD("Empty Fields", "Please fill in all fields", null);
        }
    }

    public void validateLogin() {
        email = usernameTextField.getText();
        password = passwordField.getText();
        if (email.equals("admin") && password.equals("admin")) {
            AppAlert.IS_LOGIN_SUCCESS();
            Platform.runLater(() -> {
//                new MenuView().setVisible(true);
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
            });

        } else {
            login(email, password);
        }
    }

    private void login(String email_phone, String password) {
        // Create a new thread to avoid blocking the Swing event dispatch thread
        new Thread(() -> {
            try {
                // Replace with your API URL
                String apiUrl = APIConstants.BASE_URL + "/users/login";
                // Create the payload as a map and convert it to JSON
                Map<String, String> payload = Map.of(
                    "email_phone", email_phone, // Replace with actual value
                    "password", password // Replace with actual value
                );

                // Send the request and get the response
                HttpResponse<String> response = ApiUtils.postRequest(apiUrl, payload);

                // Handle the response
                switch (response.statusCode()) {
                    case 200:
                        AppAlert.IS_LOGIN_SUCCESS();

                        Platform.runLater(() -> {
//                            new MenuView().setVisible(true);
                            Stage stage = (Stage) loginButton.getScene().getWindow();
                            stage.close();
                        });

                        break;
                    case 400:
                        JOptionPane.showMessageDialog(null,
                                                      "Username or password is incorrect, please try again!");
                        throw new BadCredentialsException("Username or password is incorrect");
                    default:
                        JOptionPane.showMessageDialog(null,
                                                      "Internal server error, please try again later!");
                        break;
                }
            } catch (IOException | InterruptedException | BadCredentialsException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        }).start();
    }

    public void loginHereAction(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            URL url = getClass().getResource("/org/example/hsf301/fxml/login.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            // Get the current stage (the window that contains the login button)
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Option 1: Replace the current scene with the signup scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            // Option 2: Open signup.fxml in a new window
            // Stage newStage = new Stage();
            // newStage.setScene(new Scene(root));
            // newStage.show();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}