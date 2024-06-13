package com.fsa.ims.interviewsystemmanagement.Controller;

import com.fsa.ims.interviewsystemmanagement.DB.Entity.Candidate;
import com.fsa.ims.interviewsystemmanagement.Model.CandidateDTO;
import com.fsa.ims.interviewsystemmanagement.services.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @GetMapping("/candidate-list")
    public String getCandidate(Model model) {
        List<CandidateDTO> candidates = candidateService.findAll();
        model.addAttribute("candidates", candidates);
        return "candidate-list";
    }

    @GetMapping("/search")
    public List<Candidate> searchCandidate(@RequestParam Map<String, String> params) {
        String query = params.get("search-query");
        String criteria = params.get("search-criteria");
        return candidateService.searchCandidatesByCriteria(criteria, query);
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("candidate") Candidate candidate, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        candidateService.saveCandidate(candidate);
        return "redirect:/candidates-list"; // Redirect to a list page or a success page
    }

}
