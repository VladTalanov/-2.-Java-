package com.example.playground.ToyStore.model.domain;

import com.example.playground.ToyStore.model.domain.entity.Toy;

import java.util.List;

public interface IRepository {

    List<Toy> getAllToys();

    int createToy(Toy toy);

    void updateToy(Toy toy);

    void deleteToy(Toy toy);

    void saveToy(Toy toy);
}