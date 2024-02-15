package de.toxic2302.inventorymanagementsystem;

import de.toxic2302.inventorymanagementsystem.model.Item;
import de.toxic2302.inventorymanagementsystem.repository.ItemRepository;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private final ItemRepository repository;

    public Initializer(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Utah JUG", "Dallas JUG", "Tampa JUG", "Nashville JUG", "Detroit JUG")
                .forEach(name -> repository.save(new Item(name)));

        Item jug = repository.findByName("Tampa JUG");
        repository.save(jug);

        repository.findAll().forEach(System.out::println);
    }
}
