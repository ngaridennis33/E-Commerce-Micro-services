package com.northfaceclone.userservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "First Name Should NOT be blank")
    @Size(min = 3, max = 30, message = "First Name must be between 3 and 30 characters")
    @Column(name = "firstName")
    private String firstname;

    @NotBlank(message = "Last Name Should NOT be blank")
    @Size(min = 3, max = 30, message = "Last Name must be between 3 and 30 characters")
    @Column(name = "lastName")
    private String lastname;

    @NaturalId
    @NotBlank(message = "Email Should NOT be blank")
    @Size(max = 50)
    @Email(message = "Input must be in Email format")
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, max = 10, message = "Password must be between 8 and 10 characters")
    private String password;

    @Size(min = 3, max = 30, message = "User Name must be between 3 and 30 characters")
    private String userName;

    @NotBlank(message = "Phone Number Should NOT be blank")
    @Pattern(regexp = "^\\+84[0-9]{9,10}$|^0[0-9]{9,10}$", message = "The phone number is not in the correct format")
    @Size(min = 10, max = 11, message = "Phone number must be between 10 and 11 characters")
    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    @Pattern(regexp = "^(http|https)://.*$", message = "Avatar URL must be a valid HTTP or HTTPS URL")
    @Column(name = "imageUrl")
    private String avatar;

    private boolean accountLocked;
    private boolean enabled;
    private LocalDateTime dateOfBirth;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                        .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return password;
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

    public String fullName(){
        return firstname + " " + lastname;
    }

}
