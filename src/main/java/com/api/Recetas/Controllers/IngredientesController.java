package com.api.Recetas.Controllers;

import com.api.Recetas.Models.IngredientesModel;
import com.api.Recetas.Models.RecetaModel;
import com.api.Recetas.Services.IngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ingredientes")
public class IngredientesController {
    @Autowired
    IngredientesService ingredientesService;

    @GetMapping
    public List<IngredientesModel> ListarIn(){
        return ingredientesService.ListarIngredientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientesModel> ListarInId(@PathVariable Long id){
        Optional<IngredientesModel> ingredientes = ingredientesService.ListarIngredientesId(id);
        if(ingredientes.isPresent()){
            return new ResponseEntity<>(ingredientes.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ing")
    public List<IngredientesModel> ListarIxR(int rec){
        return ingredientesService.ListarIRecetas(rec);
    }

    @PostMapping
    public ResponseEntity<IngredientesModel> CrearIn(@RequestBody IngredientesModel ingredientesModel){
        IngredientesModel cingredientes = ingredientesService.CrearIngredientes(ingredientesModel);
        return new ResponseEntity<>(cingredientes, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientesModel> EditarIn(@PathVariable Long id, @RequestBody IngredientesModel ingredientesModel){
        IngredientesModel eingredientes = ingredientesService.EditarIngredientes(ingredientesModel, id);
        if (eingredientes!=null){
            return new ResponseEntity<>(eingredientes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IngredientesModel> EliminarIn(@PathVariable Long id){
        ingredientesService.EliminarIngredientes(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
