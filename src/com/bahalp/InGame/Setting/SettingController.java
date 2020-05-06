package com.bahalp.InGame.Setting;

import com.bahalp.GameEngine.GrillNumber;
import com.bahalp.Main;
import com.bahalp.GameEngine.Pion;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingController implements Initializable {

    public ChoiceBox grillChoiceBox2;
    public TextField player1Name;
    public ChoiceBox pionChoiceBox1;
    public TextField player2Name;
    public ChoiceBox pionChoiceBox2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();


    }

    public void load(){

        grillChoiceBox2.getItems().addAll(GrillNumber.TROIS.getName(), GrillNumber.CINQ.getName(), GrillNumber.SEPT.getName());

        pionChoiceBox1.getItems().addAll(Pion.O.getPion(),Pion.X.getPion());
        pionChoiceBox2.getItems().addAll(Pion.O.getPion(),Pion.X.getPion());


        grillChoiceBox2.setValue(grillChoiceBox2.getItems().get(0));

        pionChoiceBox1.setValue(pionChoiceBox1.getItems().get(0));
        pionChoiceBox2.setValue(pionChoiceBox2.getItems().get(0));
    }

    public void backToMenu(ActionEvent actionEvent) {
        try {
            Main.setRoot("Menu/MenuView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void launch2(ActionEvent actionEvent) {
        if (!player1Name.getText().equals("") && !player2Name.getText().equals("")){
            try {
                Main.gameMode.setPlayer1(player1Name.getText());
                Main.gameMode.setPlayer2(player2Name.getText());

                Main.gameMode.setPion1(Pion.valueOf((String) pionChoiceBox1.getValue()));
                Main.gameMode.setPion2(Pion.valueOf((String) pionChoiceBox2.getValue()));

                Main.gameMode.setConfig();
                Main.gameMode.getGame().setGrill(((String) grillChoiceBox2.getValue()).charAt(0) - '0');

                Main.setRoot("InGame/"+ grillChoiceBox2.getValue() + "_GameView.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
