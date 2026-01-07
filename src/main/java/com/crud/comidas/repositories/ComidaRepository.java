package com.crud.comidas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.comidas.enums.Categoria;
import com.crud.comidas.models.ComidaModel; 
/** */
@Repository
public interface ComidaRepository extends JpaRepository<ComidaModel, Long> {

    // filtros
    List<ComidaModel> findByCategoria(Categoria categoria); //JPA identifica palabras clave
    List<ComidaModel> findByNombreContaining(String nombre);

    boolean existsByNombre(String nombre);

    // filtrar por precio
    // filtrar por vegetariano
    // filtrar por vegano 
    // filtrar por sin tacc

    /**
     Prefijos validos:
        find
        read
        get
        query
        count
        exists
        delete
     
     Operadores válidos:
        And
        Or
        Between
        LessThan
        GreaterThan
        Like
        Containing
        StartingWith
        EndingWith
        IsNull
        IsNotNull
        True / False
        In
        IgnoreCase

    */

}
