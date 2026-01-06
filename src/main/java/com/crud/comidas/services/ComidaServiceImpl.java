package com.crud.comidas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<ComidaModel> findById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
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

}
