package com.example.playground.ToyStore.model.domain;

import com.example.playground.ToyStore.model.domain.entity.Toy;

public interface IValidator {

    boolean validateToy(Toy toy);
}