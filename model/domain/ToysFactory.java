package com.example.playground.ToyStore.model.domain;

import com.example.playground.ToyStore.model.domain.entity.Toy;

public class ToysFactory implements IToysFactory {

    @Override
    public Toy getNewToy(String name, int quantity, int chancePercentage) {
        return new Toy(
                name,
                quantity,
                chancePercentage
        );
    }
}