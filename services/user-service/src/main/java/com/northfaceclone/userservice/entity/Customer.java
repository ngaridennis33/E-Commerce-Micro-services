package com.northfaceclone.userservice.entity;

import com.northfaceclone.userservice.models.BaseEntity;
import com.northfaceclone.userservice.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class  Customer extends BaseEntity implements UserDetails, Principal {

    @NotNull
    @Size(min = 1, max = 50)
    private String firstname;
    @NotNull
    @Size(min = 1, max = 50)
    private String lastname;
    @Email
    @Column(unique = true)
    private String email;
    private String password;
    private String userName;
    private LocalDateTime dateOfBirth;
    private String phoneNumber;
    private String avatar;
    private boolean accountLocked;
    private boolean enabled;
//    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String fullName() {
        return firstname + " " + lastname;
    }

    @Override
    public String getName() {
        return email;
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }
}

