package com.kozlovsky.user.repository;

import com.kozlovsky.user.model.SigninEnity;
import com.kozlovsky.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by anton on 24.03.17.
 */
@Component
public interface SinginRepository extends JpaRepository<SigninEnity, String > {
}
