package com.microservice.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "product_id")
    private Integer id;

    @Column(name= "product_name")
    private String name;

    @Column(name= "product_brand")
    private String brand;

    @Column(name= "product_price")
    private double price;

}
