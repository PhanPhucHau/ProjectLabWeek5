package com.example.labweek05.fontend.controllers;


import com.example.labweek05.backend.models.Candidate;
import com.example.labweek05.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

  //  @GetMapping("/list")
  //  public String listCandidates(Model model) {
  //      model.addAttribute("candidates", candidateService.findAllCandidates());
  //      return "candidates/index";
  //  }

    @GetMapping("")
    public String listCadidateWithPaging(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            Model model){
        int pageNo = page.orElse(1);
        int pageSize = size.orElse(10);


        Page<Candidate> candidatePage = candidateService.findCandidatesWithPagination(pageNo - 1, pageSize, "id", "asc");
        model.addAttribute("candidates", candidatePage.getContent());
        model.addAttribute("totalPages", candidatePage.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);

        return "candidates/index";
    }
}
