package com.example.house_services.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.house_services.dtos.OperatorDto;
import com.example.house_services.services.OperatorService;

import java.util.List;

@RestController
@RequestMapping("/api/operators")
@RequiredArgsConstructor
public class OperatorController {
    private final OperatorService operatorService;

    // @GetMapping
    // public ResponseEntity<List<OperatorDto>> getAllOperators() {
    //     return ResponseEntity.ok(operatorService.getAllOperators());
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<OperatorDTO> getOperatorById(@PathVariable Long id) {
    //     return ResponseEntity.ok(operatorService.findById(id));
    // }

    // @PostMapping
    // public ResponseEntity<OperatorDTO> createOperator(@RequestBody OperatorDTO operatorDTO) {
    //     return ResponseEntity.ok(operatorService.create(operatorDTO));
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<OperatorDTO> updateOperator(
    //         @PathVariable Long id, 
    //         @RequestBody OperatorDTO operatorDTO) {
    //     return ResponseEntity.ok(operatorService.update(id, operatorDTO));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteOperator(@PathVariable Long id) {
    //     operatorService.delete(id);
    //     return ResponseEntity.noContent().build();
    // }
}