package com.amt.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MedMalek on 28/04/2015.
 */
@Entity
@Table(name = "users")
public class UsersEntity implements Serializable {
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String role;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "users_seq",
                       allocationSize = 1,
                       initialValue = 1,
                       sequenceName = "users_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "users_seq")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username",
            unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String phone;

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @PreUpdate
    @PrePersist
    private void encodePassword() {
        password = new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersEntity)) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        return !(phone != null ? !phone.equals(that.phone) : that.phone != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
