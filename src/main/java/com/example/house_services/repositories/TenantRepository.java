package com.example.house_services.repositories;

import com.example.house_services.models.Tenant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    
    // Поиск по email или телефону
    @Query("SELECT t FROM Tenant t WHERE t.email = :contact OR t.phoneNumber = :contact")
    Tenant findByEmailOrPhone(String contact);
    
    // Поиск по адресу (частичное совпадение)
    List<Tenant> findByRegistrationAddressContainingIgnoreCase(String addressPart);
}
