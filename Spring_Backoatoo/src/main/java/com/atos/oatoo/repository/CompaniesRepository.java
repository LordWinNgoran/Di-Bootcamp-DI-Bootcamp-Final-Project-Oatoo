package com.atos.oatoo.repository;

import com.atos.oatoo.models.Companies;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CompaniesRepository extends CrudRepository<Companies, Long>{

    @Query(nativeQuery=true,value ="SELECT c.* FROM companies c WHERE c.user_fk=:user_fk")
    List<Companies> findByUser( int user_fk);

    @Modifying
    @Query(nativeQuery=true,value ="UPDATE companies c SET c.account_state ='A' WHERE c.id =:id")
    void UpdateCompanyAccount(long id);

}
