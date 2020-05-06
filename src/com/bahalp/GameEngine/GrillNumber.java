package com.bahalp.GameEngine;

public enum GrillNumber {
    TROIS ("3X3"),
    CINQ ("5X5"),
    SEPT ("7X7");

    private String name;

    GrillNumber(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
