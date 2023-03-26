package com.example.playground.ToyStore.model.domain;

import com.example.playground.ToyStore.model.domain.entity.Toy;

public interface IToysFactory {

    Toy getNewToy(String name, int quantity, int chancePercentage);
}