package com.api.Recetas.Controllers;

import com.api.Recetas.Models.RecetaModel;
import com.api.Recetas.Services.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/receta")
public class RecetaController {
    @Autowired
    RecetaService recetaService;

    @GetMapping
    public List<RecetaModel> ListarR(){
        return recetaService.ListarReceta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetaModel> ListarRId(@PathVariable Long id){
        Optional<RecetaModel> receta = recetaService.ListarRecetaId(id);
        if (receta.isPresent()){
            return new ResponseEntity<>(receta.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cat")
    public List<RecetaModel> ListarRxC(@PathVariable int cat){
        return recetaService.ListarRCategoria(cat);
    }

    @PostMapping
    public ResponseEntity<RecetaModel> CrearR(@RequestBody RecetaModel recetaModel){
        RecetaModel creceta = recetaService.CrearReceta(recetaModel);
        return new ResponseEntity<>(creceta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecetaModel> EditarR(@PathVariable Long id, @RequestBody RecetaModel recetaModel){
        RecetaModel ereceta = recetaService.EditarReceta(recetaModel, id);
        if (ereceta!=null){
            return new ResponseEntity<>(ereceta, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RecetaModel> EliminarR(@PathVariable Long id){
        recetaService.EliminarReceta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
