package com.example.house_services.repositories;

import com.example.house_services.models.RepairTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepairTeamRepository extends JpaRepository<RepairTeam, Long> {
    
    // Поиск бригад, работающих над конкретной заявкой
    // @Query("SELECT rt FROM RepairTeam rt JOIN rt.assignedRequests r WHERE r.id = :requestId")
    // List<RepairTeam> findByAssignedRequest(Long requestId);
}