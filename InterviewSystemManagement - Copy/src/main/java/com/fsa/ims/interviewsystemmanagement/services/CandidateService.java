package com.fsa.ims.interviewsystemmanagement.services;

import com.fsa.ims.interviewsystemmanagement.DB.Entity.Candidate;
import com.fsa.ims.interviewsystemmanagement.DB.Repository.CandidateRepository;
import com.fsa.ims.interviewsystemmanagement.Model.CandidateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public List<CandidateDTO> findAll() {
        List<Candidate> candidates = candidateRepository.findAll();
        List<CandidateDTO> candidateDTOs = new ArrayList<>();
        for (Candidate candidate : candidates) {
            CandidateDTO candidateDTO = new CandidateDTO();
            candidateDTO.setCandidateName(candidate.getCandidateName());
            candidateDTO.setCandidateEmail(candidate.getCandidateEmail());
            candidateDTO.setCandidatePhone(candidate.getCandidatePhone());
            candidateDTO.setCurrentPosition(candidate.getCurrentPosition());
            candidateDTO.setOwnerHR(candidate.getOwnerHR());
            candidateDTO.setStatus(candidate.getStatus());
            candidateDTOs.add(candidateDTO);
        }
        return candidateDTOs;
    }

    public List<Candidate> searchCandidatesByCriteria(String criteria, String query) {
        switch (criteria) {
            case "name":
                return candidateRepository.findByCandidateNameContaining(query);
            case "email":
                return candidateRepository.findByCandidateEmailContaining(query);
            case "phone":
                return candidateRepository.findByCandidatePhoneContaining(query);
            case "position":
                return candidateRepository.findByCurrentPositionIsContaining(query);
            case "ownerHR":
                return candidateRepository.findByOwnerHRContaining(query);
            case "status":
                return candidateRepository.findByStatusContaining(query);
            default:
                return List.of();
        }
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Integer id, Candidate candidate) {
        Optional<Candidate> existingCandidate = candidateRepository.findById(id);
        if (existingCandidate.isPresent()) {
            Candidate updatedCandidate = existingCandidate.get();
            updatedCandidate.setCandidateName(candidate.getCandidateName());
            updatedCandidate.setDateOfBirth(candidate.getDateOfBirth());
            updatedCandidate.setCandidatePhone(candidate.getCandidatePhone());
            updatedCandidate.setCandidateEmail(candidate.getCandidateEmail());
            updatedCandidate.setCandidateAddress(candidate.getCandidateAddress());
            updatedCandidate.setCandidateGender(candidate.getCandidateGender());
            updatedCandidate.setCurrentPosition(candidate.getCurrentPosition());
            updatedCandidate.setSkills(candidate.getSkills());
            updatedCandidate.setOwnerHR(candidate.getOwnerHR());
            updatedCandidate.setNote(candidate.getNote());
            updatedCandidate.setStatus(candidate.getStatus());
            updatedCandidate.setYearOfExperience(candidate.getYearOfExperience());
            updatedCandidate.setHighestLevel(candidate.getHighestLevel());
            return candidateRepository.save(updatedCandidate);
        } else {
            throw new RuntimeException("Candidate not found with id " + id);
        }
    }

}
