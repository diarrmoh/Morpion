package com.bahalp.Menu;

import com.bahalp.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void chooseMode(ActionEvent actionEvent) {
        try {
            Main.setRoot("InGame/Setting/SettingView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
