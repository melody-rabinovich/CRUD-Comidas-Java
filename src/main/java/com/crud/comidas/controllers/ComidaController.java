package com.crud.comidas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.comidas.services.ComidaService;

@RestController
@RequestMapping("/api/comidas")
public class ComidaController {
    private final ComidaService comidaService;

    @Autowired
    public ComidaController(ComidaService comidaService){
        this.comidaService = comidaService;

    }
    

}
