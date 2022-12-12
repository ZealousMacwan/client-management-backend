package com.example.ClientManagementBackend.datamodels;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name= "client")
public class Client {
    @GeneratedValue
    @Id
    private Long id;

    private String name;
    private String email;

    //getter and setter using lombok
}
