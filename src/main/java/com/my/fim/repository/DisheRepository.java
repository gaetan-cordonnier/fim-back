package com.my.fim.repository;

import com.my.fim.model.Dishe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisheRepository extends JpaRepository<Dishe, Long> {
}
