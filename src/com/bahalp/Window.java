package com.bahalp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Window {
    private Stage stage;
    private int width;
    private int heigth;
    private String name;
    private Parent root;

    public Window(Stage stage, int width, int heigth, Parent root, String name) {
        this.stage  = stage;
        this.width  = width;
        this.heigth = heigth;
        this.root   = root;
        this.name   = name;
    }

    public Window(Stage stage, int width, int heigth, String name) {
        this.stage = stage;
        this.width = width;
        this.heigth = heigth;
        this.name = name;
    }

    public Window(Stage stage) {
        this.stage = stage;
    }

    public void setConfig() {
        if (Main.getScreenSize()[0] == 1280) stage.setFullScreen(true);
        stage.setTitle(this.name);
        Scene s = new Scene(this.root, this.width, this.heigth);
        stage.setScene(s);
        stage.getIcons().add(new Image(Window.class.getResourceAsStream("Data/Morpion.png")));
    }

    public void show(){
        this.stage.show();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }
}
