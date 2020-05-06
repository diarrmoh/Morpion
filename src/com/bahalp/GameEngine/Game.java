package com.bahalp.GameEngine;

public class Game {
    public int tour;
    int nbOfPionToWin;
    public boolean victory;
    private String player1;
    private String player2;
    private Pion pion1;
    private Pion pion2;
    private int grill[][];


    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.victory = false;
        this.nbOfPionToWin = 3;
    }

    public void play(int i, int j) {
        grill[i][j] = this.tour;
        setVictory(victory());

    }

    private boolean victory() {
        //For lign and colum
        for (int i = 0; i < grill.length; i++){
            int j1c = 0;
            int j2c = 0;
            int j1l = 0;
            int j2l = 0;
            for (int j = 0; j < grill[0].length; j++){
                if (grill[i][j] != 0) j1c = 0;
                else j1c++;
                if (grill[i][j] != 1) j2c = 0;
                else j2c++;
                if (grill[j][i] != 0) j1l = 0;
                else j1l++;
                if (grill[j][i] != 1) j2l = 0;
                else j2l++;
                if (j1c > nbOfPionToWin - 1 || j2c > nbOfPionToWin - 1 || j1l > nbOfPionToWin - 1 || j2l > nbOfPionToWin - 1) return true;
            }
        }

        //For diagonals
        for(int k = 0; k < 2; k++){
            int j1d = 0;
            int j2d = 0;
            for (int i = 0; i < grill.length ; i++){
                if (grill[i + (k*grill.length) - k*(2*i + 1)][i] != 0) j1d = 0;
                else j1d++;
                if (grill[i + (k*grill.length) - k*(2*i + 1)][i] != 1) j2d = 0;
                else j2d++;
                if (j1d > nbOfPionToWin - 1 || j2d > nbOfPionToWin - 1) return true;
            }
        }

        return false;
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

    public int[][] getGrill() {
        return grill;
    }

    public void setGrill(int size) {
        this.grill = new int[size][size];
        initGrill();
        if (grill.length > 3)setNbOfPionToWin(4);
    }

    private void initGrill() {
        for (int i = 0; i < grill.length; i++){
            for (int j = 0; j < grill[0].length; j++){
                grill[i][j] = 2;
            }
        }
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public void changeTour(){
        this.tour++;
        this.tour %= 2;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public void setGrill(int[][] grill) {
        this.grill = grill;
    }

    public boolean isVictory() {
        return victory;
    }

    public void replay(){
        initGrill();
        setTour(0);
        setVictory(false);
    }

    public int getNbOfPionToWin() {
        return nbOfPionToWin;
    }

    public void setNbOfPionToWin(int nbOfPionToWin) {
        this.nbOfPionToWin = nbOfPionToWin;
    }

    public int[] initTab(int[] tab){
        for (int i = 0; i < tab.length; i++){
            tab[i] = 0;
        }
        return tab;
    }

}
