package com.example.house_services.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantDto {
    private Long id;
    private String email;
    private String password;
    private String phoneNumber;
    private String fullName;
    private String passportNumber;
    private String registrationAddress;
}