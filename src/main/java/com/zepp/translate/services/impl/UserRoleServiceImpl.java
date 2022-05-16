package com.zepp.translate.services.impl;

import com.zepp.translate.entities.user.security.UserRole;
import com.zepp.translate.exceptions.NotFoundException;
import com.zepp.translate.repositories.UserRoleRepository;
import com.zepp.translate.services.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void deleteUserRole(long userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }

    @Override
    public void deleteUserRole(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

    @Override
    public UserRole findById(long userRoleId) {
        Optional<UserRole> optionalUserRole = userRoleRepository.findById(userRoleId);
        if(!optionalUserRole.isPresent()){
            throw new NotFoundException("Nije pronađen userRole sa ID-jem "+ userRoleId);
        }
        UserRole userRole = optionalUserRole.get();
        return userRole;
    }
}
