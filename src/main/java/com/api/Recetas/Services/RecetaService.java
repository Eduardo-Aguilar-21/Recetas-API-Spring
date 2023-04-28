package com.api.Recetas.Services;

import com.api.Recetas.Models.RecetaModel;
import com.api.Recetas.Repositories.RecetaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetaService {
    @Autowired
    RecetaRepository recetaRepository;
    
    public List<RecetaModel> ListarReceta(){
       return recetaRepository.findAll();
    }
    
    public Optional<RecetaModel> ListarRecetaId(Long id){
        return recetaRepository.findById(id);
    }
    
    public RecetaModel CrearReceta(RecetaModel recetaModel){
        return recetaRepository.save(recetaModel);
    }
    
    public RecetaModel EditarReceta(RecetaModel recetaModel, Long id){
        Optional<RecetaModel> existing = recetaRepository.findById(id);
        if(existing.isPresent()){
            RecetaModel receta = existing.get();
            receta.setNom_rec(recetaModel.getNom_rec());
            receta.setCategoriaModel(recetaModel.getCategoriaModel());
            return recetaRepository.save(receta);
        }
        return null;
    }
    
    public void EliminarReceta(Long id){
        recetaRepository.deleteById(id);
    }
}
