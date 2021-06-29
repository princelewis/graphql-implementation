package com.udacity.dog_api.config;

import com.udacity.dog_api.entity.Dog;
import com.udacity.dog_api.repository.DogRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config {


    private DogRepository repository;

    public Config(DogRepository repository) {
        this.repository = repository;
    }
    @PostConstruct
    public void init() {
        Dog dog1 = new Dog("Bingo", "Caucashian", "America");
        Dog dog2 = new Dog("Bull Dog", "Caucashian", "British");
        Dog dog3 = new Dog("Jaguar", "cross-breed", "German");

            repository.save(dog1);
            repository.save(dog2);
            repository.save(dog3);
    }
}
