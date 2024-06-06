package com.ism.interviewsystemmanagement.DB.Entity;

import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer candidateID;

    @Column(name = "cand_name")
    @NotNull
    @Pattern(regexp = "^[a-zA-z\s]{6,}", message = "name must atleast have 6 characters or more and did not include special character ")
    private String candidateName;

    @Column(name = "cand_email")
    @NotNull
    @Email(message = "Email is invalid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String candidateEmail;

    @Column(name = "cand_gender")
    private CandidateGender candidateGender;

    @Column(name = "cand_DOB")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime dateOfBirth;

    @Column(name = "cand_address")
    private String candidateAddress;




    @Column(name = "camd_phone")
    @NotNull
    @Pattern(regexp = "^[0-9]{10,11}", message = "phone number only accept numbers and need 10-11 numbers for phone number")
    private String candidatePhone;


    @Column(name = "professional_info")
    private String professionalInformation;


    @Column(name = "cand_current_position")
    @Enumerated(EnumType.STRING)
    private CurrentPosition currentPosition;

    @Column(name = "skill")
    private String Skills;

    @Column(name = "highest_level")
    private String highestLevel;

    @Column(name = "owner_HR")
    private String ownerHR;

    @Column(name = "cand_status")
    private CandidateStatus status;

    //    Current Position Validation
    private enum CurrentPosition {
        Backend, BA, Tester, HR, PM, NotAvailable
    }

    private enum CandidateStatus {
        Open, WaitingForInterview, Canceled, Passed, Failed, WaitingForApproval,
        Approved, Rejected, WaitingForResponse, AcceptedOffer, DeclinedOffer, CancelledOffer, Banned
    }

    private enum CandidateGender {
        Male, Female
    }
}

