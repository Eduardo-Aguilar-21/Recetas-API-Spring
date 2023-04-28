package com.api.Recetas.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id_cat;
    private String nom_cat;
    private String des_cat;
    @JsonIgnore
    @OneToMany(mappedBy = "categoriaModel")
    private List<RecetaModel> receta;
}
