package com.boby.onlinecourses.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.*;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDto {

    @NotNull
    @Email
    private String email;

    //    @JsonIgnore
    @NotNull
    @Size(min = 8,max = 32,message = "Password must be between 8 and 32 symbols")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#\\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$",message = "Password does not match requirements (ex. P@ss1234).")
    private String password;

    @NotNull
    @Size(min = 2,max = 20,message = "First name must be between 2 and 20 symbols")
    private String username;


    @URL
    @Size(min = 2,max = 200,message = "Invalid profile picture URL")
    private String picture_url;



    @NotNull
    private String role_id;

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", pictureUrl='" + picture_url + '\'' +
                ", roles='" + role_id + '\'' +
                '}';
    }
}