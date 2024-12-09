package com.example.labweek05.fontend.controllers;

import com.example.labweek05.backend.models.Job;
import com.example.labweek05.backend.services.CompanyService;
import com.example.labweek05.backend.services.JobService;
import com.example.labweek05.backend.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private CompanyService companyService;

  //  @GetMapping("/jobs")
  //  public String listJobs(Model model) {
  //      model.addAttribute("jobs", jobService.getAllJobs());
  //      return "jobs/index";
  //  }

  //  @GetMapping("/jobs")
  //  public String createJob(Model model) {
  //      model.addAttribute("skills", skillService.getAllSkills());
  //      model.addAttribute("job", new Job());
  //      model.addAttribute("jobs", jobService.getAllJobs());
  //      model.addAttribute("companies", companyService.getAllCompanies());
  //      return "jobs/index";
  //  }
  @GetMapping
  public String listJobs(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "5") int size,
                         Model model) {
      Page<Job> jobPage = jobService.getJobsWithPagination(PageRequest.of(page, size));
      model.addAttribute("jobs", jobPage.getContent());
      model.addAttribute("totalPages", jobPage.getTotalPages());
      model.addAttribute("currentPage", page);
      model.addAttribute("skills", skillService.getAllSkills());
      model.addAttribute("companies", companyService.getAllCompanies());
      return "jobs/index";  // Trả về trang danh sách công việc với phân trang
  }

    // Sửa công việc
    @GetMapping("/jobs/edit/{id}")
    public String editJob(@PathVariable Long id, Model model) {
        Job job = jobService.findJobById(id);
        if (job != null) {
            model.addAttribute("job", job);
            model.addAttribute("skills", skillService.getAllSkills());
            model.addAttribute("companies", companyService.getAllCompanies());
            return "jobs/edit";  // Trả về form chỉnh sửa công việc
        }
        return "redirect:/jobs";
    }

    // Xử lý sửa công việc (POST)
    @PostMapping("/jobs/edit/{id}")
    public String updateJob(@PathVariable Long id, @ModelAttribute Job job) {
        job.setId(id);
        jobService.saveJob(job);  // Lưu công việc đã chỉnh sửa
        return "redirect:/jobs";
    }

    // Xóa công việc
    @GetMapping("/jobs/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);  // Xóa công việc theo ID
        return "redirect:/jobs";  // Quay lại danh sách công việc
    }



    @PostMapping("/jobs")
    public String saveJob(Job job) {
        jobService.saveJob(job);
        return "redirect:/jobs";
    }
}
