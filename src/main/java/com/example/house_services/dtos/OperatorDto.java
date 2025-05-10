package com.example.house_services.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatorDto {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private List<Long> requestIds; // Только ID связанных запросов
}