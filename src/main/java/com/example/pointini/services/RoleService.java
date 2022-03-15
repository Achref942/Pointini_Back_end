package com.example.pointini.services;

import com.example.pointini.entities.Role;
import com.example.pointini.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleService implements RoleServiceI {
    @Autowired
    public RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {

        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(Long id) {
            return roleRepository.findById(id).get();
    }

    @Override
    public Role CreateRole(Role r ) {

        return roleRepository.save(r);
    }

    @Override
    public Role updateRole(Role r ) {
        return roleRepository.save(r);
    }

}
