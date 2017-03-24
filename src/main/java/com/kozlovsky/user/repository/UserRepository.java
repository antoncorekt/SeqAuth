package com.kozlovsky.user.repository;

import com.kozlovsky.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * @author anton
 */


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByRegisterkey(String registerkey);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE User us SET us.version=5 WHERE us.id=7 ")
    void setEnableForUserActivations();
}
