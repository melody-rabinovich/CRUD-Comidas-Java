package com.crud.comidas.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.comidas.enums.Categoria;
import com.crud.comidas.exceptions.BadRequestException;
import com.crud.comidas.exceptions.ResourceNotFoundException;
import com.crud.comidas.models.ComidaModel;
import com.crud.comidas.repositories.ComidaRepository;

import jakarta.validation.Valid;

@Service
public class ComidaServiceImpl implements ComidaService{

    private final ComidaRepository comidaRepository;

    @Autowired
    public ComidaServiceImpl(ComidaRepository comidaRepository){
        this.comidaRepository = comidaRepository;
    }

    @Override
    public List<ComidaModel> findAll() {
        return comidaRepository.findAll();
    }

    @Override
    public ComidaModel findById(long id) {
       return comidaRepository.findById(id).
        orElseThrow(() -> new ResourceNotFoundException("No se encontró una comida con el id " + id));
    }


    @Override
    public ComidaModel save( ComidaModel comida) {
        // no podría haberse creado si los datos estuvieran mal
        if(comidaRepository.existsByNombre(comida.getNombre())){
            throw new BadRequestException("Ya existe una comida con el nombre " + comida.getNombre());
        }
        if (comida.getEsVegano() && !comida.getEsVegetariano()) {
            throw new BadRequestException(
                "Una comida vegana debe ser también vegetariana"
            );
        }
        
        ComidaModel comidaGuardada = comidaRepository.save(comida);
        
       return comidaGuardada;
    }

    @Override
    public Optional<ComidaModel> deleteById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Optional<ComidaModel> update(long id, ComidaModel comidaModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }



    // filtros

    @Override
    public List<ComidaModel> findByCategoria(Categoria categoria) {
        List<ComidaModel> comidasEncontradas = comidaRepository.findByCategoria(categoria);

        if(comidasEncontradas.isEmpty()){
            throw new ResourceNotFoundException("No se econtraron comidas con la categoría <" + categoria + ">");
        }

        return comidasEncontradas;
    }


    @Override
    public List<ComidaModel> findByNombreContaining(String nombre){
        List<ComidaModel> comidasEncontradas = comidaRepository.findByNombreContaining(nombre);
        if(comidasEncontradas.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron comidas que contengan el nombre " + nombre);
        }
        return comidasEncontradas;
    }



    

    // Metodos de lógica de negocio
    // hacer un método que valide que si una comida es vegana, sea también vegetariana

}
