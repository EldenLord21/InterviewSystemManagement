package com.ism.interviewsystemmanagement.DB.Repository;

import com.ism.interviewsystemmanagement.DB.Entity.Candidate;
import com.ism.interviewsystemmanagement.Model.CandidateDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
