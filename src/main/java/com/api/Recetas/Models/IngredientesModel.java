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
@Table(name = "Ingredientes")
public class IngredientesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id_ing;
    private String nom_ing;
    private Integer cantidad;
    private String unidad_medida;
    
    @ManyToOne
    @JoinColumn(name = "receta_id", referencedColumnName = "id_rec", nullable = false)
    private RecetaModel recetaModel;

    public IngredientesModel() {
    }

    public Long getId_ing() {
        return id_ing;
    }

    public void setId_ing(Long id_ing) {
        this.id_ing = id_ing;
    }

    public String getNom_ing() {
        return nom_ing;
    }

    public void setNom_ing(String nom_ing) {
        this.nom_ing = nom_ing;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public RecetaModel getRecetaModel() {
        return recetaModel;
    }

    public void setRecetaModel(RecetaModel recetaModel) {
        this.recetaModel = recetaModel;
    }
    
    
}
