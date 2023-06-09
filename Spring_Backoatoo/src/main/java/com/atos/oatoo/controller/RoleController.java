package com.atos.oatoo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.atos.oatoo.controller.exception.EntityException;
import com.atos.oatoo.models.Role;
import com.atos.oatoo.repository.IRoleRepository;
import com.atos.oatoo.service.RoleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private RoleService roleService;

    @GetMapping()
    public List<Role> fetchRole() {
        return roleService.fetchRoleList();
    }

    @GetMapping("{id}")
    public Role fetchRoleById(@PathVariable("id") Long idRole) throws EntityException {

        return roleService.fetchRole(idRole);
    }

    @DeleteMapping("{id}")
    public String deleteAnalyse(@PathVariable("id") Long idRole) throws EntityException{
        roleService.deleteRole(idRole);
        return "Delete successfull";
    }

    @PostMapping()
    public Role saveRole(@Validated @RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @PutMapping("{id}")
    public Role updateRole(@PathVariable("id") Long idRole, @Valid @RequestBody Role role) throws EntityException{

        return  roleService.updateRole(idRole, role);
    }
}
