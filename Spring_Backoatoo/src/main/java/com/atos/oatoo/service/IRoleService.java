package com.atos.oatoo.service;

import java.util.List;

import com.atos.oatoo.controller.exception.EntityException;
import com.atos.oatoo.models.Role;

public interface IRoleService {
    public Role saveRole(Role role);

    List<Role> fetchRoleList();

    Role fetchRole(Long idARole) throws EntityException;

    void deleteRole(Long idRole) throws EntityException;

    Role updateRole(Long idRole, Role role) throws EntityException;
}
