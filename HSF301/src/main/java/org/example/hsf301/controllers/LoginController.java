package org.example.hsf301.controllers;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.net.URL;
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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.control.Notifications;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.service.AccountService;
import org.example.hsf301.service.IAccountService;
import org.example.hsf301.utils.EnvUtils;
import org.example.hsf301.utils.AppAlert;
import org.example.hsf301.utils.NavigateUtil;

@Slf4j
@Getter
@RequiredArgsConstructor
public class LoginController {

    @FXML
    public TextField usernameTextField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Button loginButton;
    public static String email = "";
    private String password = "";

    @FXML
    protected ImageView brandingImageView;
    @FXML
    protected ImageView logoImageView;
    @FXML
    protected ImageView ggImageView;
    @FXML
    protected ImageView fbImageView;
    @FXML
    protected ImageView xImageView;

    public static Account account;

    private final IAccountService accountService;

    public LoginController(AccountService accountService){
        this.accountService  = accountService;
    }

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

        Image ggImage = new Image(
            Objects.requireNonNull(
                    getClass().getResource("/org/example/hsf301/assets/img/google.png"))
                .toExternalForm());
        ggImageView.setImage(ggImage);

        Image fbImage = new Image(
            Objects.requireNonNull(
                    getClass().getResource("/org/example/hsf301/assets/img/facebook.png"))
                .toExternalForm());
        fbImageView.setImage(fbImage);

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
        login(email, password);
    }

    private void login(String username, String password) {
        account = accountService.login(username, password);

        if (account == null) {
            AppAlert.showAlert("Login Failed", "Invalid email or password");
        } else {

            Notifications.create()
                .title("Title Text")
                .text("Hello World 0!")
                .showWarning();

            String destinationPage = "";

            System.out.println(account);

            switch (account.getRole()){
                case ADMIN -> destinationPage = "AdminMainLayout";
                case SALE_STAFF -> destinationPage = "StaffMainLayout";
                case CONSULT_STAFF -> destinationPage = "StaffMainLayout";
                case DELIVERY_STAFF -> destinationPage = "StaffMainLayout";
                case CUSTOMER -> destinationPage = "MainLayout";
                default -> destinationPage = "error";
            }

            NavigateUtil.navigateTo(String.format("/org/example/hsf301/fxml/%s.fxml",
                                                  destinationPage),
                                    loginButton, 1700,
                                    850
                , "Booking Tours");
        }
    }

    @FXML
    private void loginViaGoogleAction() {
        Platform.runLater(() -> {
            String googleAuthUrl = EnvUtils.get("GOOGLE_AUTH_URL");
            try {
                URI uri = new URI(googleAuthUrl);
                if (Desktop.isDesktopSupported() && Desktop.getDesktop()
                    .isSupported(Action.BROWSE)) {
                    Desktop.getDesktop().browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void loginViaFacebookAction() {
        Platform.runLater(AppAlert::IS_NOT_SUPPORT);
    }

    @FXML
    public void signupHereAction(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            URL url = getClass().getResource("/org/example/hsf301/fxml/signup.fxml");
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


    public void forgotPasswordAction(ActionEvent actionEvent) {
        String api = "http://localhost:3000/forgot-password";
        Platform.runLater(() -> {
            try {
                // Specify the URL of the website
                URI uri = new URI(api);
                // Open the website in the default browser
                if (Desktop.isDesktopSupported() && Desktop.getDesktop()
                    .isSupported(Action.BROWSE)) {
                    Desktop.getDesktop().browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }


}