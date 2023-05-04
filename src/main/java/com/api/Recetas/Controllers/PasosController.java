package com.api.Recetas.Controllers;

import com.api.Recetas.Models.PasosModel;
import com.api.Recetas.Services.PasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pasos")
public class PasosController {
    @Autowired
    PasosService pasosService;

    @GetMapping
    public List<PasosModel> ListarP(){
        return pasosService.ListarPasos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasosModel> ListarPId(@PathVariable Long id){
        Optional<PasosModel> pasos = pasosService.ListarPasosId(id);
        if (pasos.isPresent()){
            return new ResponseEntity<>(pasos.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PasosModel> CrearP(@RequestBody PasosModel pasosModel){
        PasosModel cpasos = pasosService.CrearPasos(pasosModel);
        return new ResponseEntity<>(cpasos, HttpStatus.CREATED;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasosModel> EditarP(@RequestBody PasosModel pasosModel, @PathVariable Long id){
        PasosModel epasos = pasosService.EditarPasos(pasosModel, id);
        if(epasos!=null){
            return new ResponseEntity<>(epasos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PasosModel> EliminarP(@PathVariable Long id){
        pasosService.EliminarPasos(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
