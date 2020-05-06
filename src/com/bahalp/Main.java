package com.bahalp;

import com.bahalp.GameEngine.GameMode;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

import static javafx.fxml.FXMLLoader.*;

public class Main extends Application {
    public static Window window;
    public static GameMode gameMode;
    public static Random random;


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = new Window(primaryStage, 1280, 720,"Morpion");
        setRoot("Menu/MenuView.fxml");
        window.show();
    }


    public static void main(String[] args) {
       Sound sound=new Sound(String.valueOf(Main.class.getResource("Data/music.mp3")));
       sound.play();

        gameMode = new GameMode();
        random = new Random();
        launch(args);


    }

    public static int[] getScreenSize(){
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int size[] = new int[2];
        if((int)dimension.getWidth() < 1920){
            size[1] = 720;
            size[0] = 1280;
        } else {
            size[1] = 1080;
            size[0] = 1920;
        }
        return size;
    }

    public static void setRoot(String path) throws IOException {
        System.out.println(path);
        Parent root = load(Main.class.getResource(path));
        window.setRoot(root);
        window.setConfig();
    }

}
