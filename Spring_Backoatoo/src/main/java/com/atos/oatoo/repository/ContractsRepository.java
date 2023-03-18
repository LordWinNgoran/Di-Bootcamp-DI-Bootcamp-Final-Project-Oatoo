package com.atos.oatoo.repository;

import com.atos.oatoo.models.Contracts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContractsRepository extends CrudRepository<Contracts, Long>{
    
}
