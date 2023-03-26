package com.example.playground.ToyStore.views;

import com.example.playground.ToyStore.model.domain.entity.Toy;

public class ToysAdapterImpl implements IToysAdapter {

    @Override
    public String getView(Toy toy) {
        return toy.toString();
    }
}