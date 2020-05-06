package com.bahalp.InGame;

import com.bahalp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public Image[] image;
    private String next[];

    public ImageView pionjoueur2;
    public Text joueur2;
    public ImageView pionjoueur1;
    public Text joueur1;
    public GridPane grid;
    public Text tour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
    }

    public void load(){
        image = new Image[2];
        image[0] = new Image(String.valueOf(Main.class.getResource("Data/" + Main.gameMode.getPion1().getPion() + "/" + Main.gameMode.getPion1().getPion() + ".png")));
        image[1] = new Image(String.valueOf(Main.class.getResource("Data/" + Main.gameMode.getPion2().getPion() + "/" + Main.gameMode.getPion2().getPion() + ".png")));

        pionjoueur1.setImage(image[0]);
        pionjoueur2.setImage(image[1]);

        joueur1.setText(Main.gameMode.getGame().getPlayer1());
        joueur2.setText(Main.gameMode.getGame().getPlayer2());

        Main.gameMode.getGame().setTour(0);

        tour.setText(joueur1.getText());

        next = new String[2];
        next[0] = joueur1.getText();
        next[1] = joueur2.getText();
    }

    public void backToMenu(ActionEvent actionEvent) {
        try {
            Main.setRoot("Menu/MenuView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void replay(ActionEvent actionEvent) {
        Main.gameMode.getGame().replay();
        load();
        refresh();
    }

    public void play(MouseEvent mouseEvent) {
        if (!Main.gameMode.getGame().victory){
            int i = (int) (((ImageView) mouseEvent.getSource()).getBoundsInParent().getMinX()/(grid.getHeight()/Main.gameMode.getGame().getGrill().length));
            int j = (int) (((ImageView) mouseEvent.getSource()).getBoundsInParent().getMinY()/(grid.getHeight()/Main.gameMode.getGame().getGrill().length));
            System.out.println(i + "  " + j);
            if (((ImageView)mouseEvent.getSource()).getImage() == null){
                ((ImageView)mouseEvent.getSource()).setImage(image[Main.gameMode.getGame().getTour()]);
                Main.gameMode.getGame().play(i,j);
                if (!Main.gameMode.getGame().victory){
                    Main.gameMode.getGame().changeTour();
                    tour.setText(next[Main.gameMode.getGame().getTour()]);
                } else {
                    tour.setText("Bravo " + tour.getText());
                }

            }

            if (tour.equals("IA")){

            }
        }

    }

    public void refresh(){
        for (int i = 0; i < Main.gameMode.getGame().getGrill().length*Main.gameMode.getGame().getGrill().length; i++){
            ((ImageView) grid.getChildren().get(i)).setImage(null);
        }
    }

}
