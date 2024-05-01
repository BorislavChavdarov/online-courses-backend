package com.boby.onlinecourses.models;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_type")
    private String roleType;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}