package com.example.chothuenha.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MessageForm {

    @NotEmpty
    @NotBlank
    @NotNull
    private String content;

    @NotEmpty
    @NotBlank
    @NotNull
    private Long user;

    @NotEmpty
    @NotBlank
    @NotNull
    private Long friend;

    public MessageForm() {
    }

    public MessageForm(@NotEmpty @NotBlank @NotNull String content, @NotEmpty @NotBlank @NotNull Long user, @NotEmpty @NotBlank @NotNull Long friend) {
        this.content = content;
        this.user = user;
        this.friend = friend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getFriend() {
        return friend;
    }

    public void setFriend(Long friend) {
        this.friend = friend;
    }
}
