package com.atos.oatoo.repository;

import com.atos.oatoo.models.Companies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends CrudRepository<Companies, Long>{

}
