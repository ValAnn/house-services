package com.example.house_services.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.house_services.dtos.TenantDto;
import com.example.house_services.models.Tenant;
import com.example.house_services.services.TenantService;

import java.util.List;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {
    private final TenantService tenantService;
    private final ModelMapper modelMapper;

    private TenantDto toDto(Tenant entity) {
        return modelMapper.map(entity, TenantDto.class);
    }

    private Tenant toEntity(TenantDto dto) {
        return modelMapper.map(dto, Tenant.class);
    }

    @GetMapping
    public ResponseEntity<List<TenantDto>> getAllTenants() {
        return ResponseEntity.ok(tenantService.getAllTenants().stream()
                .map(this::toDto)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantDto> getTenantById(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(tenantService.getTenantById(id)));
    }

    @PostMapping
    public ResponseEntity<TenantDto> createTenant(@RequestBody TenantDto tenantDto) {
        return ResponseEntity.ok(toDto(tenantService.createTenant(toEntity(tenantDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TenantDto> updateTenant(
            @PathVariable Long id,
            @RequestBody TenantDto tenantDto) {
        return ResponseEntity.ok(toDto(tenantService.updateTenant(id, toEntity(tenantDto))));
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteTenant(@PathVariable Long id) {
    //     tenantService.deleteTenant(id);
    //     return ResponseEntity.noContent().build();
    // }
}