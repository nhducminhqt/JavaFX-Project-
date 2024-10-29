package org.example.hsf301;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.service.AccountService;
import org.example.hsf301.utils.AudioUtils;
import org.example.hsf301.utils.LogsUtils;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/hsf301/fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 830, 650);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        AccountService accountService = new AccountService("hibernate.cfg.xml");

        LogsUtils.ensureLogsFolderExists();

        AudioUtils.getInstance().playAudio(HelloApplication.class.getResourceAsStream(
            ResourcePaths.URL_INTRO));

        launch();

    }
}