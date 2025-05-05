package com.example.house_services.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.house_services.models.Operator;
import com.example.house_services.models.Request;
import com.example.house_services.models.RequestStatus;
import com.example.house_services.models.Tenant;
import com.example.house_services.repositories.RequestRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final TenantService tenantService;
    private final OperatorService operatorService;

    public Request createRequest(Request request, Long tenantId) {
        Tenant tenant = tenantService.getTenantById(tenantId);
        request.setTenant(tenant);
        request.setStatus(RequestStatus.CREATED);
        request.setCreatingDate(LocalDateTime.now());
        return requestRepository.save(request);
    }

    public Request getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found with id: " + id));
    }

    public List<Request> getRequestsByStatus(RequestStatus status) {
        return requestRepository.findByStatus(status);
    }

    public Request assignOperator(Long requestId, Long operatorId) {
        Request request = getRequestById(requestId);
        Operator operator = operatorService.getOperatorById(operatorId);
        request.setOperator(operator);
        request.setStatus(RequestStatus.ASSIGNED);
        return requestRepository.save(request);
    }

    public List<Request> getRequestsByTenant(Long tenantId) {
        return requestRepository.findByTenantId(tenantId);
    }

    public Request updateRequestStatus(Long id, RequestStatus status) {
        Request request = getRequestById(id);
        request.setStatus(status);
        return requestRepository.save(request);
    }
}
