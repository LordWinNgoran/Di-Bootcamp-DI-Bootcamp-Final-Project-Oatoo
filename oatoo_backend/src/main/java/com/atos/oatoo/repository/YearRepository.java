package com.atos.oatoo.repository;

import com.atos.oatoo.models.Year;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends CrudRepository<Year, Long>{
    
}
