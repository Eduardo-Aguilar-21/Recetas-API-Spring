package com.api.Recetas.Services;

import com.api.Recetas.Models.PasosModel;
import com.api.Recetas.Models.RecetaModel;
import com.api.Recetas.Repositories.PasosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasosService {
    @Autowired
    PasosRepository pasosRepository;
    
    public List<PasosModel> ListarPasos(){
        return pasosRepository.findAll();
    }
    
    public Optional<PasosModel> ListarPasosId(Long id){
        return pasosRepository.findById(id);
    }
    
    public PasosModel CrearPasos(PasosModel pasosModel){
        return pasosRepository.save(pasosModel);
    }
    
    public PasosModel EditarPasos(PasosModel pasosModel, Long id){
        Optional<PasosModel> existing = pasosRepository.findById(id);
        if(existing.isPresent()){
            PasosModel pasos = existing.get();
            pasos.setOrden(pasosModel.getOrden());
            pasos.setD_paso(pasosModel.getD_paso());
            pasos.setRecetaModel(pasosModel.getRecetaModel());
            return pasosRepository.save(pasos);
        }
        return null;
    }
    
    public void EliminarPasos(Long id){
        pasosRepository.deleteById(id);
    }

    public List<PasosModel> ListarPReceta(int precs){
        List<Objects[]> resultados = pasosRepository.FiltrarP(precs);
        List<PasosModel> pasosxrec = new ArrayList<>();

        for(Object[] resultado : resultados){
            PasosModel pasosm = (PasosModel) resultado[0];
            RecetaModel recetam = (RecetaModel) resultado[1];
            pasosm.setRecetaModel(recetam);
            pasosxrec.add(pasosm);
        }
        return pasosxrec;
    }
}
