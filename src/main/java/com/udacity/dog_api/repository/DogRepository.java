package com.udacity.dog_api.repository;

import com.udacity.dog_api.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    String GET_BREEDS = "SELECT breed FROM dog";
    @Query(value = GET_BREEDS, nativeQuery = true)
    List<String> getAllBreeds();

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    Optional<String> getBreedById(@Param("id") Long id);

    @Query("SELECT d.name FROM Dog d")
    List<String> getAllNames();
}
