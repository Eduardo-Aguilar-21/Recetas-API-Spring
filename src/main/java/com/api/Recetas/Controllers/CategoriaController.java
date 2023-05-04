package com.api.Recetas.Controllers;

import com.api.Recetas.Models.CategoriaModel;
import com.api.Recetas.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaModel> ListarC(){
        return categoriaService.ListarCategoria();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> ListarCId(@PathVariable Long id){
        Optional<CategoriaModel> categoria = categoriaService.ListarCategoriaId(id);
        if (categoria.isPresent()){
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> CrearC(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel ccategoria = categoriaService.CrearCategoria(categoriaModel);
        return new ResponseEntity<>(ccategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> EditarC(@PathVariable Long id, @RequestBody CategoriaModel categoriaModel){
        CategoriaModel ecategoria = categoriaService.EditarCategoria(categoriaModel, id);
        if (ecategoria!=null){
            return new ResponseEntity<>(ecategoria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaModel> EliminarC(@PathVariable Long id){
        categoriaService.Eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
