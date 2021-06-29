package com.udacity.dog_api.service;

import com.udacity.dog_api.entity.Dog;
import com.udacity.dog_api.response.DogResponse;

import java.util.List;
import java.util.Optional;

public interface DogService {
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();

}
