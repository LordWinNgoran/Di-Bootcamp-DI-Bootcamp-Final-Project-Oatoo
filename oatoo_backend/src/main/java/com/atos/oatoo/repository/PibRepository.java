package com.atos.oatoo.repository;

import com.atos.oatoo.models.Pib;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PibRepository extends CrudRepository<Pib, Long>{
    
}
