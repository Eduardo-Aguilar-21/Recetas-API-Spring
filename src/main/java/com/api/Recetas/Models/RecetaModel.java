package com.api.Recetas.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Receta")
public class RecetaModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id_rec;
    private String nom_rec;
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_cat", nullable = false)
    private CategoriaModel categoriaModel;
    
    @JsonIgnore
    @OneToMany(mappedBy = "recetaModel")
    private List<IngredientesModel> ingredientes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "recetaModel")
    private List<PasosModel> pasos;

    public RecetaModel() {
    }

    public Long getId_rec() {
        return id_rec;
    }

    public void setId_rec(Long id_rec) {
        this.id_rec = id_rec;
    }

    public String getNom_rec() {
        return nom_rec;
    }

    public void setNom_rec(String nom_rec) {
        this.nom_rec = nom_rec;
    }

    public CategoriaModel getCategoriaModel() {
        return categoriaModel;
    }

    public void setCategoriaModel(CategoriaModel categoriaModel) {
        this.categoriaModel = categoriaModel;
    }

    public List<IngredientesModel> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredientesModel> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<PasosModel> getPasos() {
        return pasos;
    }

    public void setPasos(List<PasosModel> pasos) {
        this.pasos = pasos;
    }
    
    
}
