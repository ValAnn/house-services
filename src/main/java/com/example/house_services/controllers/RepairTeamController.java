package com.example.house_services.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.house_services.dtos.RepairTeamDto;
import com.example.house_services.models.RepairTeam;
import com.example.house_services.services.RepairTeamService;

import java.util.List;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api/repair-teams")
@RequiredArgsConstructor
public class RepairTeamController {
    private final RepairTeamService repairTeamService;
    private final ModelMapper modelMapper;

    private RepairTeamDto toDto(RepairTeam entity) {
        return modelMapper.map(entity, RepairTeamDto.class);
    }

    private RepairTeam toEntity(RepairTeamDto dto) {
        return modelMapper.map(dto, RepairTeam.class);
    }

    @GetMapping
    public ResponseEntity<List<RepairTeamDto>> getAllRepairTeams() {
        return ResponseEntity.ok(repairTeamService.getAllRepairTeams().stream()
                .map(this::toDto)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairTeamDto> getRepairTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(repairTeamService.getRepairTeamById(id)));
    }

    @PostMapping
    public ResponseEntity<RepairTeamDto> createRepairTeam(@RequestBody RepairTeamDto repairTeamDto) {
        return ResponseEntity.ok(toDto(repairTeamService.createRepairTeam(toEntity(repairTeamDto))));
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<RepairTeamDto> updateRepairTeam(
    //         @PathVariable Long id,
    //         @RequestBody RepairTeamDto repairTeamDto) {
    //     return ResponseEntity.ok(toDto(repairTeamService.updateRepairTeam(id, toEntity(repairTeamDto))));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteRepairTeam(@PathVariable Long id) {
    //     repairTeamService.deleteRepairTeam(id);
    //     return ResponseEntity.noContent().build();
    // }
}
