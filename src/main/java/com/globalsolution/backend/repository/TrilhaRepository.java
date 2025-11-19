package com.globalsolution.backend.repository;


import com.globalsolution.backend.entity.TrilhaDeAprendizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaRepository extends JpaRepository<TrilhaDeAprendizado, Long> {
}