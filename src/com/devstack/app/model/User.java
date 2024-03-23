package com.devstack.app.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",nullable = false)
    @ColumnDefault("unknwon")
    private String fullName;

    @Column(name = "username",nullable = false,unique = true)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;
}
