package com.zepp.translate.services;

import com.zepp.translate.entities.user.User;
import com.zepp.translate.entities.user.security.UserRole;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    User findByEmail (String email);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);

    List<User> findUsers();

    Optional<User> findUser(Long userId);
    void deleteById(long userId);
    Optional<User> findById(long id);
    long userCount();
}
