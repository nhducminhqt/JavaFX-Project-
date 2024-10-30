package org.example.hsf301.layouts;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import org.example.hsf301.views.utils.NavigateUtil;

public class StaffMainController {

    @FXML
    private StackPane contentArea;

    @FXML
    private void navigateLogout() throws IOException {
        NavigateUtil.navigateTo("/org/example/hsf301/fxml/login.fxml", contentArea, 830, 650, "Hello!");
    }
}
