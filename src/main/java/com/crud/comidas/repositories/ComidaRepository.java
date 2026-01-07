package com.crud.comidas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.comidas.enums.Categoria;
import com.crud.comidas.models.ComidaModel; 

@Repository
public interface ComidaRepository extends JpaRepository<ComidaModel, Long> {

    List<ComidaModel> findByCategoria(Categoria categoria); //JPA identifica palabras clave

}
