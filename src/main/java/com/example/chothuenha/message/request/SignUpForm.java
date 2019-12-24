package com.example.chothuenha.message.request;

import javax.validation.constraints.*;
import java.util.Set;

public class SignUpForm {
    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(max = 60)
    @Email
    private String email;

    private Set<String> role;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(max = 40, min = 6)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
