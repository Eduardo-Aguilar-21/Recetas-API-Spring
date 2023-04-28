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
@Table(name = "Pasos")
public class PasosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_pasos;
    private String orden;
    private String d_paso;
    
    @ManyToOne
    @JoinColumn(name = "receta_id", referencedColumnName = "id_rec", nullable = false)
    private RecetaModel recetaModel;

    public PasosModel() {
    }

    public Long getId_pasos() {
        return id_pasos;
    }

    public void setId_pasos(Long id_pasos) {
        this.id_pasos = id_pasos;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getD_paso() {
        return d_paso;
    }

    public void setD_paso(String d_paso) {
        this.d_paso = d_paso;
    }

    public RecetaModel getRecetaModel() {
        return recetaModel;
    }

    public void setRecetaModel(RecetaModel recetaModel) {
        this.recetaModel = recetaModel;
    }
    
}
