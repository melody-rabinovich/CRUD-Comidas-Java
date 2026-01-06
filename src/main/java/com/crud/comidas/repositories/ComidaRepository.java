package com.crud.comidas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crud.comidas.models.ComidaModel; 

@Repository
public interface ComidaRepository extends JpaRepository<ComidaModel, Long> {

}
