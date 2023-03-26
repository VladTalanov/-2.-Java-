package com.example.playground.ToyStore.controllers;

import com.example.playground.ToyStore.model.domain.IShopController;
import com.example.playground.ToyStore.model.domain.IRepository;
import com.example.playground.ToyStore.model.domain.IValidator;
import com.example.playground.ToyStore.model.domain.entity.Toy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ShopController implements IShopController {

    private final IRepository repository;
    private final IValidator validator;

    private final LinkedHashSet<Toy> pickedToys = new LinkedHashSet<>();

    public ShopController(IRepository repository, IValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void saveToy(Toy toy) throws Exception {
        validateToy(toy);
        repository.createToy(toy);
    }

    @Override
    public Toy readToy(int id) throws Exception {
        List<Toy> toys = repository.getAllToys();
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }

        throw new Exception("Toy not found");
    }

    @Override
    public List<Toy> readList() {
        List<Toy> result = repository.getAllToys();
        return result;
    }

    @Override
    public void updateToy(int id, Toy newToy) throws Exception {
        idPresenceValidation(id);
        newToy.setId(id);
        validateToyId(newToy);
        repository.updateToy(newToy);
    }

    @Override
    public void deleteToy(int id) throws Exception {
        idPresenceValidation(id);
        repository.deleteToy(
                readToy(id)
        );
    }

    @Override
    public void idPresenceValidation(int id) throws Exception {
        List<Toy> toys = repository.getAllToys();
        for (Toy item : toys) {
            if (item.getId() == id)
                return;
        }
        throw new Exception("No such ID here");
    }

    @Override
    public List<Toy> pickToy(int id) {
        try {
            pickedToys.add(readToy(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Toy>(pickedToys);
    }

    @Override
    public List<Toy> popToy() {
        Toy toy = (new ArrayList<Toy>(pickedToys)).get(0);
        repository.saveToy(toy);
        pickedToys.remove(toy);
        return new ArrayList<Toy>(pickedToys);
    }

    private void validateToy(Toy toy) throws Exception {
        if (!validator.validateToy(toy)) {
            throw new Exception("Toy name has unacceptable characters");
        }
    }

    private void validateToyId(Toy toy) throws Exception {
        if (toy.getId() < 0)
            throw new Exception("Toy has no id");
        validateToy(toy);
    }
}