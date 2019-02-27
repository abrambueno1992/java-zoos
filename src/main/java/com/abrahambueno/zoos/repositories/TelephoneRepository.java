package com.abrahambueno.zoos.repositories;

import com.abrahambueno.zoos.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
