package com.example.house_services.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.house_services.dtos.OperatorDto;
import com.example.house_services.models.Operator;
import com.example.house_services.services.OperatorService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api/operators")
@RequiredArgsConstructor
public class OperatorController {
    private final OperatorService operatorService;
    private final ModelMapper modelMapper;

    private OperatorDto toDto(Operator entity) {
        return modelMapper.map(entity, OperatorDto.class);
    }

    private Operator toEntity(OperatorDto dto) {
        final Operator entity = modelMapper.map(dto, Operator.class);
        // entity.setAuthor(authorService.get(dto.getAuthorId()));
        return entity;
    }

    @GetMapping
    public ResponseEntity<List<OperatorDto>> getAllOperators() {
       return ResponseEntity.ok(operatorService.getAllOperators().stream()
       .map(this::toDto)
       .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperatorDto> getOperatorById(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(operatorService.getOperatorById(id)));
    }

    @PostMapping
    public ResponseEntity<OperatorDto> createOperator(@RequestBody OperatorDto operatorDto) {
        return ResponseEntity.ok(toDto(operatorService.createOperator(toEntity(operatorDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperatorDto> updateOperator(
            @PathVariable Long id, 
            @RequestBody OperatorDto operatorDto) {
        return ResponseEntity.ok(toDto(operatorService.updateOperator(id, toEntity(operatorDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperator(@PathVariable Long id) {
        operatorService.deleteOperator(id);
        return ResponseEntity.noContent().build();
    }
}