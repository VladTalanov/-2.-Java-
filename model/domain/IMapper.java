package com.example.playground.ToyStore.model.domain;

import com.example.playground.ToyStore.model.domain.entity.Toy;

public interface IMapper {

    String map(Toy toy);

    Toy map(String line);
}