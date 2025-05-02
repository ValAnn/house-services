package com.example.house_services.repositories;

import com.example.house_services.models.Request;
import com.example.house_services.models.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    
    // Поиск заявок по статусу
    List<Request> findByStatus(RequestStatus status);
    
    // Поиск заявок по ID арендатора
    List<Request> findByTenantId(Long tenantId);
    
    // Поиск заявок за период
    // List<Request> findByCreatingAtBetween(LocalDateTime start, LocalDateTime end);
    
    // Поиск заявок, назначенных оператору
    @Query("SELECT r FROM Request r WHERE r.operator.id = :operatorId")
    List<Request> findByOperator(Long operatorId);
    
}