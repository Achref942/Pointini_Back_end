package com.example.pointini.services;

import com.example.pointini.entities.Role;
import com.example.pointini.entities.User;

import java.util.List;

public interface RoleServiceI {
    List<Role> getAllRole();

    Role findRoleById(Long id);

    Role CreateRole(Role r);

    Role updateRole(Role r);

}
