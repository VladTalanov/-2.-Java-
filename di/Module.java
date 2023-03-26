package com.example.playground.ToyStore.di;

import com.example.playground.ToyStore.controllers.ShopController;
import com.example.playground.ToyStore.model.data.FileStorage;
import com.example.playground.ToyStore.model.domain.ILogger;
import com.example.playground.ToyStore.model.domain.IMapper;
import com.example.playground.ToyStore.model.domain.IShopController;
import com.example.playground.ToyStore.model.domain.IToysFactory;
import com.example.playground.ToyStore.model.domain.IRepository;
import com.example.playground.ToyStore.model.domain.IStorage;
import com.example.playground.ToyStore.model.domain.IValidator;
import com.example.playground.ToyStore.model.domain.LoggerImpl;
import com.example.playground.ToyStore.model.domain.MapperIml;
import com.example.playground.ToyStore.model.data.RepositoryImpl;
import com.example.playground.ToyStore.model.domain.ToysFactory;
import com.example.playground.ToyStore.views.IToysAdapter;
import com.example.playground.ToyStore.views.IView;
import com.example.playground.ToyStore.views.ShopView;
import com.example.playground.ToyStore.views.ToysAdapterImpl;
import com.example.playground.ToyStore.views.Promptable;
import com.example.playground.ToyStore.views.PromptableImpl;
import com.example.playground.ToyStore.views.PromptableLoggingDecorator;

public class Module {

    public static IStorage provideStorage() {
        return new FileStorage("toys.txt");
    }

    public static IMapper provideMapper() {
        return new MapperIml();
    }

    public static IValidator provideValidator() {
        return new MapperIml();
    }

    public static IRepository provideRepository(
            IStorage storage,
            IMapper mapper
    ) {
        return new RepositoryImpl(mapper, storage);
    }

    public static IShopController provideNoteController(
            IRepository repository,
            IValidator validator
    ) {
        return new ShopController(repository, validator);
    }

    public static ILogger provideLogger() {
        return new LoggerImpl("log.txt");
    }

    public static Promptable providePromptable(
            ILogger logger
    ) {
        return new PromptableLoggingDecorator(
                new PromptableImpl(),
                logger
        );
    }

    public static IToysAdapter provideToysAdapter() {
        return new ToysAdapterImpl();
    }

    public static IToysFactory provideNotesFactory() {
        return new ToysFactory();
    }

    public static IView provideView(
            IShopController controller,
            Promptable promptable,
            IToysAdapter notesAdapter,
            IToysFactory notesFactory
    ) {
        return new ShopView(controller, promptable, notesAdapter, notesFactory);
    }
}