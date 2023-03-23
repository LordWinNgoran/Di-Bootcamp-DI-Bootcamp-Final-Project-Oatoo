package com.atos.oatoo.repository;

import com.atos.oatoo.models.Contract_types;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contract_typesRepository extends CrudRepository<Contract_types, Long>{
    
}
