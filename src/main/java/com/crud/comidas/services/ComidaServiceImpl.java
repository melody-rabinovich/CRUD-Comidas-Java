package com.crud.comidas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.comidas.enums.Categoria;
import com.crud.comidas.exceptions.ResourceNotFoundException;
import com.crud.comidas.models.ComidaModel;
import com.crud.comidas.repositories.ComidaRepository;

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
    public List<ComidaModel> findByCategoria(Categoria categoria) {
        List<ComidaModel> comidasEncontradas = comidaRepository.findByCategoria(categoria);

        if(comidasEncontradas.isEmpty()){
            throw new ResourceNotFoundException("No se econtraron comidas con la categoría <" + categoria + ">");
        }

        return comidasEncontradas;
    }


    @Override
    public Optional<ComidaModel> save(ComidaModel comidaModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
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

    

    // Metodos de lógica de negocio
    // hacer un método que valide que si una comida es vegana, sea también vegetariana

}
