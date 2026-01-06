package com.crud.comidas.services;

import java.util.List;
import java.util.Optional;

import com.crud.comidas.models.ComidaModel;

public interface ComidaService {
    List<ComidaModel> findAll();
    Optional<ComidaModel> findById(long id);
    Optional<ComidaModel> save(ComidaModel comidaModel);
    Optional<ComidaModel> deleteById(long id);
    Optional<ComidaModel> update(long id, ComidaModel comidaModel);
    
}
