package com.abrahambueno.zoos.repositories;

import com.abrahambueno.zoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepository extends JpaRepository<Zoo, Long> {
}
