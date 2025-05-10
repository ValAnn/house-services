package com.example.house_services.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.house_services.models.RepairTeam;
import com.example.house_services.models.Request;
import com.example.house_services.repositories.RepairTeamRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RepairTeamService {
    private final RepairTeamRepository repairTeamRepository;
    private final RequestService requestService;

    public RepairTeam createRepairTeam(RepairTeam team) {
        return repairTeamRepository.save(team);
    }

    public RepairTeam getRepairTeamById(Long id) {
        return repairTeamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repair team not found with id: " + id));
    }

    public List<RepairTeam> getAllRepairTeams(){
        return repairTeamRepository.findAll();
    }

    public RepairTeam assignToRequest(Long teamId, Long requestId) {
        RepairTeam team = getRepairTeamById(teamId);
        Request request = requestService.getRequestById(requestId);
        // team.getRequests().add(request);
        return repairTeamRepository.save(team);
    }

    // public List<Request> getTeamAssignedRequests(Long teamId) {
    //     return repairTeamRepository.findAssignedRequestsByTeamId(teamId);
    // }
}
