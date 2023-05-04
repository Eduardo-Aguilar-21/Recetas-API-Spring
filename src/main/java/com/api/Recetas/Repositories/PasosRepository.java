package com.api.Recetas.Repositories;

import com.api.Recetas.Models.PasosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface PasosRepository extends JpaRepository<PasosModel, Long> {
    @Query("SELECT p,r FROM PasosModel p INNER JOIN RecetaModel r " +
            "ON p.recetaModel.id_rec = r.id_rec " +
            "WHERE p.recetaModel.id_rec =:id_precs")
    List<Objects[]> FiltrarP(int id_precs);
}
