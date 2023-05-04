package com.api.Recetas.Repositories;

import com.api.Recetas.Models.IngredientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientesRepository extends JpaRepository<IngredientesModel, Long> {
    @Query("SELECT p,r FROM IngredientesModel p INNER JOIN RecetaModel r " +
            "ON p.recetaModel.id_rec = r.id_rec " +
            "WHERE p.recetaModel.id_rec =:id_recs")
    List<Object[]>FiltrarIng(int id_recs);
}
