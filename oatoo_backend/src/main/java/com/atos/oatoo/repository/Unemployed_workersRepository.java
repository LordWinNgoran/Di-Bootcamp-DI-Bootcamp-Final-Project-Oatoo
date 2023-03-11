package com.atos.oatoo.repository;

import com.atos.oatoo.models.Unemployed_workers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Unemployed_workersRepository extends CrudRepository<Unemployed_workers, Long>{
    
}
