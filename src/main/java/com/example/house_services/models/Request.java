package com.example.house_services.models;

import java.sql.Date;

import com.example.house_services.repositories.RepairTeamRepository;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "requests")
public class Request extends BaseEntity {
    @Column (name = "creatingDate",nullable = false)
    private Date creatingDate;
    @Column (name = "progressDate")
    private Date progressDate;
    @Column (name = "closeDate")
    private Date closeDate;
    @Column (name = "description",nullable = false)
    private String description;
    @Column(name="status", nullable=false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")  // Столбец в таблице requests
    private Operator operator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")  // Столбец в таблице requests
    private Tenant tenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repairteam_id")  // Столбец в таблице requests
    private RepairTeam repairTeam;

    @Column(name="result")
    private String result;

    @Lob
    @Column(name = "image_data", columnDefinition = "BYTEA")
    private byte[] imageData;

    @Column(name = "content_type")
    private String contentType; // "image/jpeg", "image/png"

    @Column(name = "file_name")
    private String fileName;


}
