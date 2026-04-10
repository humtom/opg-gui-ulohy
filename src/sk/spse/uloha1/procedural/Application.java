package sk.spse.uloha1.procedural;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    private TextField textFieldc;
    private TextField textFieldf;


    @Override
    public void start(Stage stage) {
        Label labelc = new Label("Stupne Celsia :");
        Label labelf = new Label("Stupne Fahrenheita :");
        Label labelunic = new Label("°C");
        Label labelunif = new Label("°F");

        textFieldc = new TextField("0");
        textFieldf = new TextField("0");



        HBox riadok1 = new HBox(20, labelc, textFieldc,labelunic);
        HBox riadok2 = new HBox(20, labelf,textFieldf,labelunif);
        riadok1.setPadding(new Insets(10));
        riadok2.setPadding(new Insets(10));
        riadok1.setAlignment(Pos.CENTER_RIGHT);
        riadok2.setAlignment(Pos.CENTER_RIGHT);

        textFieldc.setOnKeyTyped(e -> convertCtoF());
        textFieldf.setOnKeyTyped(e -> convertFtoC());



        VBox root = new VBox(riadok1, riadok2);

        Scene scene = new Scene(root);

        stage.setTitle("Procedural Application 1");
        stage.setScene(scene);
        stage.show();
    }
    private void convertCtoF() {
        try{
            double c = Double.parseDouble(textFieldc.getText());
            double f = (1.8*c)+32;
            textFieldf.setText(Double.toString(f));

        }catch(NumberFormatException e){}
    }
    private void convertFtoC() {
        try{
            double f = Double.parseDouble(textFieldf.getText());
            double c = (f-32)/1.8;
            textFieldc.setText(Double.toString(c));

        }catch(NumberFormatException e){}
    }
}