package com.example.chothuenha.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FriendForm {
    @NotEmpty
    @NotBlank
    @NotNull
    private Long user_id;

    @NotEmpty
    @NotBlank
    @NotNull
    private Long friend_id;

    public FriendForm() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Long friend_id) {
        this.friend_id = friend_id;
    }
}
