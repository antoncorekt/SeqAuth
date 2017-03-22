package com.kozlovsky.user.repository;

import com.kozlovsky.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anton
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
