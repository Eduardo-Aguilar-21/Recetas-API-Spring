package com.api.Recetas.Services;

import com.api.Recetas.Models.IngredientesModel;
import com.api.Recetas.Models.RecetaModel;
import com.api.Recetas.Repositories.IngredientesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientesService {
    @Autowired
    IngredientesRepository ingredientesRepository;
    
    public List<IngredientesModel> ListarIngredientes(){
        return ingredientesRepository.findAll();
    }
    
    public Optional<IngredientesModel> ListarIngredientesId(Long id){
        return ingredientesRepository.findById(id);
    }
    
    public IngredientesModel CrearIngredientes(IngredientesModel ingredientesModel){
        return ingredientesRepository.save(ingredientesModel);
    }
    
    public IngredientesModel EditarIngredientes(IngredientesModel ingredientesModel, Long id){
        Optional<IngredientesModel> existing = ingredientesRepository.findById(id);
        if(existing.isPresent()){
            IngredientesModel ingredientes = existing.get();
            ingredientes.setNom_ing(ingredientesModel.getNom_ing());
            ingredientes.setCantidad(ingredientesModel.getCantidad());
            ingredientes.setUnidad_medida(ingredientesModel.getUnidad_medida());
            ingredientes.setRecetaModel(ingredientesModel.getRecetaModel());
            return ingredientesRepository.save(ingredientes);
        }
        return null;
    }
    
    public void EliminarIngredientes(Long id){
        ingredientesRepository.deleteById(id);
    }

    public List<IngredientesModel> ListarIRecetas(int id_recs){
        List<Object[]> resultados = ingredientesRepository.FiltrarIng(id_recs);
        List<IngredientesModel> ingredientexrec = new ArrayList<>();

        for (Object[] resultado : resultados){
            IngredientesModel ingredientem = (IngredientesModel) resultado[0];
            RecetaModel recetam = (RecetaModel) resultado [1];
            ingredientem.setRecetaModel(recetam);
            ingredientexrec.add(ingredientem);
        }
        return ingredientexrec;
    }
}
