package com.example.playground.ToyStore.model.domain;

import com.example.playground.ToyStore.model.domain.entity.Toy;

import java.util.List;

public interface IShopController {

    void saveToy(Toy toy) throws Exception;

    Toy readToy(int id) throws Exception;

    List<Toy> readList();

    void updateToy(int id, Toy newToy) throws Exception;

    void deleteToy(int id) throws Exception;

    void idPresenceValidation(int id) throws Exception;

    List<Toy> pickToy(int id);

    List<Toy> popToy();
}