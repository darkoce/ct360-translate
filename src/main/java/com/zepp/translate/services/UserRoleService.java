package com.zepp.translate.services;

import com.zepp.translate.entities.user.security.UserRole;

public interface UserRoleService {
    void deleteUserRole(long userRoleId);
    void deleteUserRole(UserRole userRole);
    UserRole findById(long userRoleId);
}
