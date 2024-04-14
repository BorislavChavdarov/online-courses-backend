package com.boby.onlinecourses.models;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    private int userId;
    private String email;
    private String username;
    private String password;
    private Role role;
    private String pictureUrl;

}
