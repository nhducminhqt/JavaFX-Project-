package org.example.hsf301.layouts;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.utils.NavigateUtil;

public class AdminMainController {

    @FXML
    private StackPane contentArea;

    @FXML
    private void navigateLogout() throws IOException {
        NavigateUtil.navigateTo(ResourcePaths.LOGIN_VIEW, contentArea, 830, 650, "Hello!");
    }
}
