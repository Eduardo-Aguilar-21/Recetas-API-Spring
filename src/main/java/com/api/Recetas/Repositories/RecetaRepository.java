package com.api.Recetas.Repositories;

import com.api.Recetas.Models.RecetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<RecetaModel, Long>{
    
}
