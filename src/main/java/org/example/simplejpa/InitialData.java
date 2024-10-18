package org.example.simplejpa;

import com.github.javafaker.Faker;
import org.example.simplejpa.Cat.Cat;
import org.example.simplejpa.Cat.CatService;
import org.example.simplejpa.Owner.Owner;
import org.example.simplejpa.Owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitialData implements CommandLineRunner {

    @Autowired
    private final CatService catService;
    private final OwnerService ownerService;
    private final Faker faker = Faker.instance();

    public InitialData(CatService catService, OwnerService ownerService) {
        this.catService = catService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) {
        for (long i = 0; i < 25; i++) {
            Owner owner = ownerService.saveOwner(
                    new Owner(faker.name().lastName(),
                            faker.name().firstName(),
                            faker.internet().emailAddress())
            );

            List<Cat> cats = new ArrayList<>();
            for (long j = 0; j < new Random().nextInt(1, 4); j++) {
                Cat cat = catService.addCat(new Cat(
                        faker.cat().name(),
                        faker.cat().breed(),
                        new Random().nextInt(1, 18),
                        owner
                ));
                cats.add(cat);
            }
            owner.setCats(cats);
            ownerService.saveOwner(owner);
        }
    }
}
