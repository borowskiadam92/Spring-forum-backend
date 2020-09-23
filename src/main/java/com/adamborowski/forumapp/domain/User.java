package com.adamborowski.forumapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class User {

    @Setter
    private Long id;
    @Setter
    private String name;
    @Setter
    private String surname;
    @Setter
    private String email;
    @Setter
    private String login;
    @Setter
    private String password;
    @Setter
    private String confirmPassword;

    private LocalDateTime time;
}
