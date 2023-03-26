package com.example.playground.ToyStore.di;

import com.example.playground.ToyStore.model.domain.IShopController;
import com.example.playground.ToyStore.model.domain.IRepository;
import com.example.playground.ToyStore.model.domain.IStorage;
import com.example.playground.ToyStore.views.IView;

public class Component {

    public IStorage storage;
    public IRepository repository;
    public IShopController noteController;
    public IView shopView;

    public Component() {

        storage = Module.provideStorage();
        repository = Module.provideRepository(storage, Module.provideMapper());
        noteController = Module.provideNoteController(repository, Module.provideValidator());
        shopView = Module.provideView(
                noteController,
                Module.providePromptable(
                        Module.provideLogger()
                ),
                Module.provideToysAdapter(),
                Module.provideNotesFactory()
        );
    }
}