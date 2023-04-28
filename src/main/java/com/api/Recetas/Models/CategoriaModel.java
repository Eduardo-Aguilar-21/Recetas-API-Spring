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

    public CategoriaModel() {
    }

    public Long getId_cat() {
        return id_cat;
    }

    public void setId_cat(Long id_cat) {
        this.id_cat = id_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public String getDes_cat() {
        return des_cat;
    }

    public void setDes_cat(String des_cat) {
        this.des_cat = des_cat;
    }

    public List<RecetaModel> getReceta() {
        return receta;
    }

    public void setReceta(List<RecetaModel> receta) {
        this.receta = receta;
    }   
}
