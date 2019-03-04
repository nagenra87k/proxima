package com.proxima.api.repository;

import com.proxima.api.model.Causes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CauseRepository extends JpaRepository<Causes,Long> {

    List<Causes> findByEmail(String email);
}
