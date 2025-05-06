package com.example.house_services.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private Long id;
    private LocalDateTime creatingDate;
    private LocalDateTime progressDate;
    private LocalDateTime closeDate;
    private String description;
    private String status;
    private Long operatorId;
    private Long tenantId;
    private Long repairTeamId;
    private String result;
    private String fileName;
    private String contentType;
}