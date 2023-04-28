/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.Recetas.Services;

import com.api.Recetas.Models.CategoriaModel;
import com.api.Recetas.Repositories.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    
    public List<CategoriaModel> ListarCategoria(){
        return categoriaRepository.findAll();
    }
    
    public Optional<CategoriaModel> ListarCategoriaId(Long id){
        return categoriaRepository.findById(id);
    }
    
    public CategoriaModel CrearCategoria(CategoriaModel categoriaModel){
        return categoriaRepository.save(categoriaModel);
    }
    
    public CategoriaModel EditarCategoria(CategoriaModel categoriaModel, Long id){
        Optional<CategoriaModel> existing = categoriaRepository.findById(id);
        if(existing.isPresent()){
            CategoriaModel categoria = existing.get();
            categoria.setNom_cat(categoriaModel.getNom_cat());
            categoria.setDes_cat(categoriaModel.getDes_cat());
            return categoriaRepository.save(categoria);
        }
        return null;
    }
    
    public void Eliminar(Long id){
        categoriaRepository.deleteById(id);
    }
}
