package org.example.hsf301.views.base;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AppFxBaseResources implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image brandingImage = new Image(
            Objects.requireNonNull(getClass().getResource("/org/example/hsf301/assets/img/branding.png")).toExternalForm());
        brandingImageView.setImage(brandingImage);

        Image logoImage = new Image(
            Objects.requireNonNull(getClass().getResource("/org/example/hsf301/assets/img/koi.png")).toExternalForm());
        logoImageView.setImage(logoImage);

        Image ggImage = new Image(
            Objects.requireNonNull(getClass().getResource("/org/example/hsf301/assets/img/google.png")).toExternalForm());
        ggImageView.setImage(ggImage);

        Image fbImage = new Image(
            Objects.requireNonNull(getClass().getResource("/org/example/hsf301/assets/img/facebook.png")).toExternalForm());
        fbImageView.setImage(fbImage);
    }
}
