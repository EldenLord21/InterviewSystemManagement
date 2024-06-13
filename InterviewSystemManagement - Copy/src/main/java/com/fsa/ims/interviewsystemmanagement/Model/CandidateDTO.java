package com.fsa.ims.interviewsystemmanagement.Model;

import com.fsa.ims.interviewsystemmanagement.Enum.EnumuratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDTO {
    private String CandidateName;
    private String CandidateEmail;
    private String CandidatePhone;
    private EnumuratedValue.CurrentPosition CurrentPosition;
    private String OwnerHR;
    private  EnumuratedValue.CandidateStatus Status;


}
