package com.udacity.dog_api.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.dog_api.entity.Dog;
import com.udacity.dog_api.exception.DogIdNotFoundException;
import com.udacity.dog_api.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Boolean deleteDogBreed(Long id) {
        dogRepository.deleteById(id);
        return true;
    }

    public Dog updateDogName(Long id, String name){
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isPresent()) {
            Dog newDog = dog.get();
            newDog.setName(name);
            return dogRepository.save(newDog);
        }
        throw new DogIdNotFoundException("Dog with Id " + id + "could not be found", id);
    }

}
