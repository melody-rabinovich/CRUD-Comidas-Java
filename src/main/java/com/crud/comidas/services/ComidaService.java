package com.crud.comidas.services;

import java.util.List;
import java.util.Optional;

import com.crud.comidas.enums.Categoria;
import com.crud.comidas.models.ComidaModel;

public interface ComidaService {
    List<ComidaModel> findAll();
    ComidaModel findById(long id);
    ComidaModel save(ComidaModel comidaModel);
    Optional<ComidaModel> deleteById(long id);
    Optional<ComidaModel> update(long id, ComidaModel comidaModel);
    // filtros
    List<ComidaModel> findByCategoria(Categoria categoria);
    List<ComidaModel> findByNombreContaining(String nombre);
    
}
