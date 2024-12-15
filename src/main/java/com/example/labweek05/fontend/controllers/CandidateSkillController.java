package com.example.labweek05.fontend.controllers;

import com.example.labweek05.backend.models.Candidate;
import com.example.labweek05.backend.models.CandidateSkill;
import com.example.labweek05.backend.models.Job;
import com.example.labweek05.backend.services.CandidateSKillService;
import com.example.labweek05.backend.services.CandidateService;
import com.example.labweek05.backend.services.EmailService;
import com.example.labweek05.backend.services.SkillService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/candidateskills")
public class CandidateSkillController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private CandidateSKillService candidateSKillService;

    @GetMapping
    public String listCandidateSkills(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size,
                                      Model model) {
        Page<CandidateSkill> skillPage = candidateSKillService.getCandidateSkillWithPagination(PageRequest.of(page, size));
        model.addAttribute("candidateSkills", skillPage.getContent());
        model.addAttribute("totalPages", skillPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("skills", skillService.getAllSkills());
        model.addAttribute("candidates", candidateService.findAllCandidates());
        return "candidateskills/index";
    }

    @GetMapping("/sendEmail/{candidateId}")
    public String sendEmail(@PathVariable Long candidateId) throws MessagingException {
        Candidate candidate = candidateService.findCandidateById(candidateId); // Tìm ứng viên theo ID
        if (candidate != null) {
            String subject = "Job Skill Notification";
            String body = "Dear " + candidate.getFullName() + ",\n\n" +
                    "You have been matched with the following skill: \n\n" +
                    "Thank you!";

        }
        return "redirect:/candidateskills";  // Quay lại trang danh sách CandidateSkills
    }


}
