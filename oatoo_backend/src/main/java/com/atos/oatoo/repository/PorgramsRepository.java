package com.atos.oatoo.repository;

import com.atos.oatoo.models.Programs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorgramsRepository extends CrudRepository<Programs, Long>{
    
}
