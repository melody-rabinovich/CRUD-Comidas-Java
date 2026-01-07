package com.crud.comidas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.comidas.dto.ApiResponse;
import com.crud.comidas.enums.Categoria;
import com.crud.comidas.models.ComidaModel;
import com.crud.comidas.services.ComidaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/comidas")
public class ComidaController {
    private final ComidaService comidaService;

    @Autowired
    public ComidaController(ComidaService comidaService){
        this.comidaService = comidaService;

    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ComidaModel>>> findAll(){
        List<ComidaModel> comidas = comidaService.findAll();
        
        ApiResponse<List<ComidaModel>> response = new ApiResponse<>(
            200, 
            "______COMIDAS______" , 
            comidas
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ApiResponse<ComidaModel>> findById(@PathVariable @Min(1) long id){
        ComidaModel comidaEncontrada = comidaService.findById(id);
        
        return ResponseEntity.ok(new ApiResponse<>(200, "comida encontrada:", comidaEncontrada));
        
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<ApiResponse<List<ComidaModel>>> findByCategoria(@PathVariable Categoria categoria){
        List<ComidaModel> comidasEncontradas = comidaService.findByCategoria(categoria);
        //ApiResponse<List<ComidaModel>> response = new ApiResponse<>(200, "______COMIDAS CON CATEGORIA " + categoria + "______", comidasEncontradas);
        return ResponseEntity.ok( new ApiResponse<>(200, "______COMIDAS CON CATEGORIA " + categoria + "______", comidasEncontradas));
    }
    

}
