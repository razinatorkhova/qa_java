package com.example;

import java.util.List;

public class Cat {

    Predator predator;

    public Cat(Predator predatorMock) {
        this.predator = predatorMock;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
