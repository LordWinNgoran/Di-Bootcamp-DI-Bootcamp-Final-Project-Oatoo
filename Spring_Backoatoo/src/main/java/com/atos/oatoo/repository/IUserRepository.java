package com.atos.oatoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import com.atos.oatoo.models.User;

import java.util.Optional;

@RestController
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM tusers  WHERE email =:email ", nativeQuery = true)
    User findUserByEmail(String email);
    Optional<User> findByFirstnameOrEmail(String firstname, String email);

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
