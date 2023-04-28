package com.api.Recetas.Repositories;

import com.api.Recetas.Models.PasosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasosRepository extends JpaRepository<PasosModel, Long> {
    
}
