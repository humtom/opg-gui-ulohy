package sk.spse.uloha1.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    @FXML
    private TextField cField;

    @FXML
    private TextField fField;

    /**
     * Keď používateľ píše do Celsius poľa,
     * automaticky sa prepočíta Fahrenheit.
     */
    @FXML
    public void OnKeyTyped1(KeyEvent event) {
        try {
            double celsius = Double.parseDouble(cField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            fField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            fField.setText("0");
        }
    }

    /**
     * Keď používateľ píše do Fahrenheit poľa,
     * automaticky sa prepočíta Celsius.
     */
    @FXML
    public void OnKeyTyped2(KeyEvent event) {
        try {
            double fahrenheit = Double.parseDouble(fField.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            cField.setText(String.format("%.2f", celsius));
        } catch (NumberFormatException e) {
            cField.setText("0");
        }
    }
}