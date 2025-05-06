package com.example.house_services.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairTeamDto {
    private Long id;
    private String teamNumber;
}