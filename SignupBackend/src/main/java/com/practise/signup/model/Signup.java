package com.practise.signup.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "signup")
@Data
public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private List<Inventory> inventories;

}
