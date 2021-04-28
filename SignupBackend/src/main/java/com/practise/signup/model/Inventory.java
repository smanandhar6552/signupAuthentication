package com.practise.signup.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Inventory")
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ProductName")
    private String product;
    @Column(name="quantity")
    private int quantity;
    @Column(name="Comment")
    private String comment;
    @Column(name="PickupAddress")
    private String pickupAddress;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Signup userID;

}
