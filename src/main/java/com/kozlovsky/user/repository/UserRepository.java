package com.kozlovsky.user.repository;

import com.kozlovsky.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author anton
 */

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
