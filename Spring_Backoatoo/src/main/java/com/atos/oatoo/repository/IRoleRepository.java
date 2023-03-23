package com.atos.oatoo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.oatoo.models.ERole;
import com.atos.oatoo.models.Role;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
