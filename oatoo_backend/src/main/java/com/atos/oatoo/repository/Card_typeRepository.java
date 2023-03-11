package com.atos.oatoo.repository;

import com.atos.oatoo.models.Card_type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Card_typeRepository extends CrudRepository<Card_type, Long>{
    
}
