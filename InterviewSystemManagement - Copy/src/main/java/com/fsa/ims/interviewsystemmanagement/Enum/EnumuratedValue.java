package com.fsa.ims.interviewsystemmanagement.Enum;

public class EnumuratedValue {
    //    Current Position Validation
    public enum CurrentPosition {
        Backend, BA, Tester, HR, PM, NotAvailable
    }

    public enum CandidateStatus {
        Open, WaitingForInterview, Canceled, Passed, Failed, WaitingForApproval,
        Approved, Rejected, WaitingForResponse, AcceptedOffer, DeclinedOffer, CancelledOffer, Banned
    }

    public enum CandidateGender {
        Male, Female
    }
}
