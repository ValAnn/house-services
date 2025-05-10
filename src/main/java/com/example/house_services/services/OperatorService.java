package com.example.house_services.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.house_services.models.Operator;
import com.example.house_services.repositories.OperatorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperatorService {
    private final OperatorRepository operatorRepository;

    public Operator createOperator(Operator operator) {
        if (operatorRepository.existsByEmail(operator.getEmail())) {
            throw new IllegalStateException("Operator with this email already exists");
        }
        return operatorRepository.save(operator);
    }

    public Operator getOperatorById(Long id) {
        return operatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operator not found with id: " + id));
    }

    public List<Operator> getAllOperators() {
        return operatorRepository.findAll();
    }

    public Operator updateOperator(Long id, Operator operatorDetails) {
        Operator operator = getOperatorById(id);
        operator.setFullName(operatorDetails.getFullName());
        operator.setEmail(operatorDetails.getEmail());
        operator.setPassword(operatorDetails.getPassword());
        return operatorRepository.save(operator);
    }

    public void deleteOperator(Long id) {
        Operator operator = getOperatorById(id);
        operatorRepository.delete(operator);
    }

    public List<Operator> searchOperatorsByName(String namePart) {
        return operatorRepository.findByFullNameContainingIgnoreCase(namePart);
    }

    
}