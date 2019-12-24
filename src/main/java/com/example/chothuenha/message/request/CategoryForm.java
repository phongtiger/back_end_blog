package com.example.chothuenha.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryForm {
    private Long id;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 1)
    private String name;

    public CategoryForm() {
    }

    public CategoryForm(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
