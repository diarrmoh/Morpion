module Morpion {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires javafx.media;

    requires java.desktop;

    opens com.bahalp.Menu;
    opens com.bahalp.InGame;
    opens com.bahalp.InGame.Setting;
    opens com.bahalp;
}