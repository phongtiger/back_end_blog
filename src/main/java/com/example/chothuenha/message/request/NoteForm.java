package com.example.chothuenha.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NoteForm {
    private Long id;
    @NotBlank
    @NotEmpty
    @NotNull
    private String name;

    @NotBlank
    @NotEmpty
    @NotNull
    private String content;
    private String url;

    @NotBlank
    @NotEmpty
    @NotNull
    private Long category_id;

    @NotBlank
    @NotEmpty
    @NotNull
    private Long user_id;

    public NoteForm() {
    }

    public NoteForm(Long id, String name, String content, String url, Long category_id, Long user_id) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.url = url;
        this.category_id = category_id;
        this.user_id = user_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
