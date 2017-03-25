package com.kozlovsky.user.model;

import com.kozlovsky.common.model.BaseEntity;
import com.kozlovsky.common.rsa.Rsa;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import sun.reflect.misc.ReflectUtil;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.List;

/**
 * @author anton
 */
@Entity
@Table(name = "user_accounts")
public class User extends BaseEntity<Long> {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", length = 100,nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "enaeble")
    private String enaeble;

    @Column(name = "register_key")
    private String registerkey;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20, nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "sign_in_provider", length = 20)
    private SocialMediaService signInProvider;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<SigninEnity> acc;


    public User() {

    }

    public List<SigninEnity> getAcc() {
        return acc;
    }

    public void setAcc(List<SigninEnity> acc) {
        this.acc = acc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnaeble(String enaeble) {
        this.enaeble = enaeble;
    }

    public void setRegisterkey(String registerkey) {
        this.registerkey = registerkey;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setSignInProvider(SocialMediaService signInProvider) {
        this.signInProvider = signInProvider;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getEnaeble() {
        return enaeble;
    }

    public String getRegisterkey() {
        return registerkey;
    }

    public SocialMediaService getSignInProvider() {
        return signInProvider;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("creationTime", this.getCreationTime())
                .append("email", email)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("modificationTime", this.getModificationTime())
                .append("signInProvider", this.getSignInProvider())
                .append("version", this.getVersion())
                .append("registerkey", this.registerkey)
                .append("enaeble", this.enaeble)
                .append("acc", this.acc)
                .append("acc_len", acc != null ? acc.size() : 0)
                .toString();
    }

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
            user.role = Role.ROLE_USER;
        }

        public Builder email(String email) {
            user.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder registerkey(String registerkey) {
            user.registerkey = registerkey;
            return this;
        }

        public Builder password(String password) {
            user.password = password;
            return this;
        }

        public Builder enaeble(String enaeble) {
            user.enaeble = enaeble;
            return this;
        }

        public Builder signInProvider(SocialMediaService signInProvider) {
            user.signInProvider = signInProvider;
            return this;
        }

        public User build() {
            return user;
        }
    }
}
