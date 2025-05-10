package com.example.house_services.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.house_services.models.Tenant;
import com.example.house_services.repositories.TenantRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TenantService {
    private final TenantRepository tenantRepository;

    public Tenant createTenant(Tenant tenant) {
        if (tenantRepository.findByEmailOrPhone(tenant.getEmail()) == null) {
            throw new IllegalStateException("Tenant with this email already exists");
        }
        return tenantRepository.save(tenant);
    }

    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + id));
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public List<Tenant> getTenantsByRegistrationAddress(String address) {
        return tenantRepository.findByRegistrationAddressContainingIgnoreCase(address);
    }

    public Tenant updateTenant(Long id, Tenant tenantDetails) {
        Tenant tenant = getTenantById(id);
        tenant.setFullName(tenantDetails.getFullName());
        tenant.setPhoneNumber(tenantDetails.getPhoneNumber());
        tenant.setRegistrationAddress(tenantDetails.getRegistrationAddress());
        return tenantRepository.save(tenant);
    }

    public Tenant findTenantByContact(String contact) {
        return tenantRepository.findByEmailOrPhone(contact);
               // .orElseThrow(() -> new RuntimeException("Tenant not found with contact: " + contact));
    }
}
