package com.example.playground.ToyStore.views;

import com.example.playground.ToyStore.model.domain.entity.Toy;

public interface IToysAdapter {

    String getView(Toy toy);
}