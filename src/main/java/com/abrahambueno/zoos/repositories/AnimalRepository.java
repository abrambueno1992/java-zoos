package com.abrahambueno.zoos.repositories;

import com.abrahambueno.zoos.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByAnimaltype(String name);
}
