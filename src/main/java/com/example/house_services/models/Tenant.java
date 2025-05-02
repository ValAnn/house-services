package com.example.house_services.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tenants")
public class Tenant extends BaseEntity{

    @Column (name = "email",unique = true,nullable = false)
    private String email;
    @Column (name = "phoneNumber",unique = true,nullable = false)
    private String phoneNumber;
    @Column (name = "password",nullable = false)
    private String password;
    @Column (name = "fullName",nullable = false)
    private String fullName;
    @Column (name = "passportNumber",unique = true,nullable = false)
    private String passportNumber;
    @Column (name = "registrationAddress",nullable = false)
    private String registrationAddress;
}
