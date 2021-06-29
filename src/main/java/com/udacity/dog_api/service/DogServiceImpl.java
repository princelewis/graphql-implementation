package com.udacity.dog_api.service;

import com.udacity.dog_api.entity.Dog;
import com.udacity.dog_api.exception.DogNotFoundException;
import com.udacity.dog_api.repository.DogRepository;
import com.udacity.dog_api.response.DogResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("dogService")
public class DogServiceImpl implements DogService {

    private DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<String> retrieveDogBreed() {
       List<String> allBreeds = dogRepository.getAllBreeds();
        return allBreeds;
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> breed = dogRepository.getBreedById(id);
        String bredRes = breed.orElseThrow(() -> new DogNotFoundException("Breed Id can't be found"));
        return bredRes;
    }

    @Override
    public List<String> retrieveDogNames() {
        List<String> allNames = dogRepository.getAllNames();
        return allNames;
    }
}
