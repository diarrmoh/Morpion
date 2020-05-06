package com.bahalp.GameEngine;

import com.bahalp.Main;

public enum Pion {
    O("O"),
    X("X");

    private String pion;

    Pion(String pion) {
        this.pion = pion;
    }

    public String getPion() {
        return pion;
    }

    public static Pion getAnotherPion(Pion pion){
        Pion p;
        do {
            p = Pion.values()[Main.random.nextInt(Pion.values().length)];
        }while (p.equals(pion));
        return p;
    }
}
