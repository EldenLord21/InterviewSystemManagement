package com.fsa.ims.interviewsystemmanagement.DB.Repository;

import com.fsa.ims.interviewsystemmanagement.DB.Entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    public List<Candidate> findByCandidateNameContaining(String name);

    public List<Candidate> findByCandidateEmailContaining(String email);

    public List<Candidate> findByCandidatePhoneContaining(String phone);

    public List<Candidate> findByCurrentPositionIsContaining(String position);

    public List<Candidate> findByOwnerHRContaining(String HR);

    public List<Candidate> findByStatusContaining(String name);

    public Candidate findById(int id);

}
