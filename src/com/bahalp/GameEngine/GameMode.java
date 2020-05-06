package com.bahalp.GameEngine;

public class GameMode {
    private String player1;
    private String player2;
    private Pion pion1;
    private Pion pion2;
    Game game;

    public GameMode() {
        player1 = "";
        player2 = "";
    }

    public void setConfig(){
        if (!player2.equals("")) game = new Game(player1,player2);
        else game = new Game(player1,"IA");
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Pion getPion1() {
        return pion1;
    }

    public void setPion1(Pion pion1) {
        this.pion1 = pion1;
    }

    public Pion getPion2() {
        return pion2;
    }

    public void setPion2(Pion pion2) {
        this.pion2 = pion2;
    }


}
