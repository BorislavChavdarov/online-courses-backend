package com.boby.onlinecourses.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Role {
    @Id
    private int roleId;
    private String roleType;


}