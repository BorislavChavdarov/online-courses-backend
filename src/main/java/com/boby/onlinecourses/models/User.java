package com.boby.onlinecourses.models;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String email;
    private String username;
    private String password;
//    @ManyToOne
//    private Role role;
    //TODO fix role/roles in db
    private String roles;
    private String pictureUrl;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Role='" + roles + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
