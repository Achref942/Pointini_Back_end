package com.example.pointini.controllers;

import com.example.pointini.entities.Role;
import com.example.pointini.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Role")
public class RoleControllers {
    @Autowired
    private RoleService roleService;
    @GetMapping(path = "/")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }
    @GetMapping(path="/{id}")
    public Role findRoleById(@PathVariable Long id) {
        return roleService.findRoleById(id);
    }
    @PostMapping(path = "/")
    public Role createRole(@RequestBody Role r) {
        return roleService.CreateRole(r);
    }
    @PutMapping(path="/")
    public Role updateRole (@RequestBody Role u) {
        return roleService.updateRole(u);
    }
}
