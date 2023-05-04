package com.api.Recetas.Repositories;

import com.api.Recetas.Models.RecetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<RecetaModel, Long>{
    @Query("SELECT r, c FROM RecetaModel r INNER JOIN CategoriaModel c " +
            "ON r.categoriaModel.id_cat = c.id_cat " +
            "WHERE r.categoriaModel.id_cat=:id_cats ")
    List<Object[]> FiltrarCat(int id_cats);
}
