package com.zepp.translate.repositories;

import com.zepp.translate.entities.user.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByname(String name);
}
