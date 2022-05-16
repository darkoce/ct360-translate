package com.zepp.translate.services.impl;

import com.zepp.translate.entities.user.security.Role;
import com.zepp.translate.repositories.RoleRepository;
import com.zepp.translate.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> setRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public Role findRole(String name) {
        return roleRepository.findByname(name);
    }
}
