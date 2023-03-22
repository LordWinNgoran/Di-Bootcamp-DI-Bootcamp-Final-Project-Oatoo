package com.atos.oatoo.repository;

import com.atos.oatoo.models.Companies;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CompaniesRepository extends CrudRepository<Companies, Long>{

    @Query(nativeQuery=true,value ="SELECT c.* FROM companies c WHERE c.user_fk=:user_fk")
    List<Companies> findByUser( int user_fk);

}
