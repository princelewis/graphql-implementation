package com.udacity.dog_api.web;

import com.udacity.dog_api.entity.Dog;
import com.udacity.dog_api.exception.DogNotFoundException;
import com.udacity.dog_api.exception.RequestNotFoundException;
import com.udacity.dog_api.repository.DogRepository;
import com.udacity.dog_api.response.DogResponse;
import com.udacity.dog_api.service.DogService;
import javassist.NotFoundException;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {

    private DogService dogService;
    private DogRepository repository;

    public DogController(DogService dogService, DogRepository repository) {
        this.dogService = dogService;
        this.repository = repository;
    }

    /**
     * {@code GET /} : fetch all the locations
     *
     *
     * @return {@link ResponseEntity} with code {@code 200 (OK)} and list of locations
     */
    @GetMapping("/breed")
    public ResponseEntity<List<String>> getAllBreeds() {
        return new ResponseEntity<>(dogService.retrieveDogBreed(), HttpStatus.OK);
    }

    /**
     * {@code GET /breed/{id}} : Get a breed by id
     * @param id The id of the Dog
     * @return {@link ResponseEntity} with code {@code 200 (OK)} if the id could be found
     * and code {@code 404 (NOT FOUND)} if the id is not found
     */
    @GetMapping("/breed/{id}")
    public ResponseEntity<String> getABreed(@PathVariable Long id) {
        String name = dogService.retrieveDogBreedById(id);

        return new ResponseEntity<>(name, HttpStatus.OK);
//        return ResponseEntity.of(name.map(x -> {
//            DogResponse response = new DogResponse(x);
//            return response;
//        }));
    }
}
