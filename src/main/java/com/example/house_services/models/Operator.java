package com.example.house_services.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "operators")
public class Operator extends BaseEntity{
    @Column (name = "email",unique = true,nullable = false)
    private String email;
    @Column (name = "password",nullable = false)
    private String password;
    @Column (name = "fullName",nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "operator")
    private List<Request> requests;
}
