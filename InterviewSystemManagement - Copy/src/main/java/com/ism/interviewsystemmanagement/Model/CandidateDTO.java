package com.ism.interviewsystemmanagement.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CandidateDTO {
    private String CandidateName;
    private String CandidateEmail;
    private String CandidatePhone;
    private String CurrentPosition;
    private String OwnerHR;
    private String Status;

}
