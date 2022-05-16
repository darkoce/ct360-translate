package com.zepp.translate.services;

import com.zepp.translate.entities.user.security.Role;

import java.util.List;

public interface RoleService {
    List<Role> setRoles();
    void saveRole(Role role);
    public Role findRole(String name);
}
