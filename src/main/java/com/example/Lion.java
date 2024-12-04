package com.example;

import java.util.List;

public class Lion {
    private Feline feline;
    private boolean hasMane;

    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;

        if ("Самец".equals(sex)) {
            hasMane = true; // Если самец, то есть грива
        } else if ("Самка".equals(sex)) {
            hasMane = false; // Если самка, то нет гривы
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }


    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
