package com.kozlovsky.user.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by anton on 24.03.17.
 */
@Entity
@Table(name = "user_signin")
public class SigninEnity implements Serializable {

    @Id
    private String id;

    @Column(name = "signin_time", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime signinTime;

    @Column(name = "ip")
    private String ip;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;

    public SigninEnity() {

    }

    public SigninEnity(DateTime signinTime, String ip) {
        this.id = UUID.randomUUID().toString();
        this.signinTime = signinTime;
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(DateTime signinTime) {
        this.signinTime = signinTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SigninEnity that = (SigninEnity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (signinTime != null ? !signinTime.equals(that.signinTime) : that.signinTime != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (signinTime != null ? signinTime.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SigninEnity{" +
                "id=" + id +
                ", signinTime=" + signinTime +
                ", ip='" + ip + '\'' +
                ", user=" + user +
                '}';
    }
}
