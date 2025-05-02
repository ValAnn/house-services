package com.example.house_services.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "repairTeams")
public class RepairTeam extends BaseEntity{
    @Column (name = "teamNumber",nullable = false)
    private String teamNumber;
    @Column (name = "password",nullable = false)
    private String password;
}
