package sk.spse.uloha4.declarative;

import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Random;

public class Controller {

    @FXML private VBox vbox1, vbox2, vbox3, vbox4;
    @FXML private ImageView img1, img2, img3, img4;

    private final Random random = new Random();

    @FXML
    private void randomize() {
        applyRandom(vbox1, img1);
        applyRandom(vbox2, img2);
        applyRandom(vbox3, img3);
        applyRandom(vbox4, img4);
    }

    private void applyRandom(VBox box, ImageView img) {
        box.setStyle("-fx-background-color: " + randomColor());

        double width = 80 + random.nextInt(200);
        double height = 80 + random.nextInt(200);
        img.setFitWidth(width);
        img.setFitHeight(height);

        img.setOpacity(0.3 + random.nextDouble() * 0.7);

        RotateTransition rt = new RotateTransition(Duration.millis(200), img);
        rt.setToAngle(random.nextInt(360));
        rt.play();
    }

    private String randomColor() {
        return String.format("#%02X%02X%02X",
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}