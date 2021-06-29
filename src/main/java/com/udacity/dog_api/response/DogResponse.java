package com.udacity.dog_api.response;

import lombok.Data;

@Data
public class DogResponse {
    public DogResponse(String breed) {
        this.breed = breed;
    }

    public DogResponse() {

    }
    private String breed;
}
