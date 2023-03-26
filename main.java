package com.example.playground.ToyStore;

import com.example.playground.ToyStore.di.Component;

public class Main {

    private static final Component appComponent = new Component();

    public static void main(String[] args) {

        appComponent.shopView.run();
    }
}