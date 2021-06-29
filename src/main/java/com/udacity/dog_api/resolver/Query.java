package com.udacity.dog_api.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dog_api.entity.Dog;
import com.udacity.dog_api.exception.DogIdNotFoundException;
import com.udacity.dog_api.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optDog = dogRepository.findById(id);

        if (optDog.isPresent()) return optDog.get();
        else throw new DogIdNotFoundException("Dog with id " + id + "was not found", id);
    }

    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }


}
