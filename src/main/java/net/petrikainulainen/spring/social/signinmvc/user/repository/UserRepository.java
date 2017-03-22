package net.petrikainulainen.spring.social.signinmvc.user.repository;

import net.petrikainulainen.spring.social.signinmvc.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anton
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
