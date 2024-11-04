package org.example.hsf301.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import lombok.Setter;
import org.example.hsf301.enums.ERole;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false,length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private ERole role;

    @Column(name = "firstName",nullable = false,length = 20)
    private String firstName;

    @Column(name = "lastName",nullable = false,length = 20)
    private String lastName;


}
