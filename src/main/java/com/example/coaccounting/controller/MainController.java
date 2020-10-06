package com.example.coaccounting.controller;

import com.example.coaccounting.model.CoWorker;
import com.example.coaccounting.model.Passport;
import com.example.coaccounting.service.CoWorkerService;
import com.example.coaccounting.service.PassportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    private final CoWorkerService coWorkerService;
    private final PassportService passportService;

    public MainController(CoWorkerService coWorkerService, PassportService passportService) {
        this.coWorkerService = coWorkerService;
        this.passportService = passportService;
    }

    @GetMapping("/main")
    public String findAll(Model model) {
        List<CoWorker> coWorkers = coWorkerService.findAll();
        model.addAttribute("coWorkers", coWorkers);
        return "main";
    }

    @GetMapping("/createCoWorker")
    public String createCoWorkerForm(CoWorker coWorker) {
        return "createCoWorker";
    }

    @PostMapping("/createCoWorker")
    public String createCoWorker(CoWorker coWorker, Passport passport) {

        coWorkerService.saveCoWorker(coWorker);
        return "redirect:/main";
    }

    @GetMapping("deleteCoWorker/{id}")
    public String deleteCoWorker(@PathVariable("id") Integer id) {
        coWorkerService.deleteById(id);
        return "redirect:/main";
    }

    @GetMapping("/updateCoWorker/{id}")
    public String updateCoWorkerForm(@PathVariable("id") Integer id, Model model){
        CoWorker coWorker = coWorkerService.findById(id);
        model.addAttribute("coWorker", coWorker);
        coWorkerService.deleteById(id);
        return "/updateCoWorker";
    }

    @PostMapping("/updateCoWorker")
    public String updateCoWorker(CoWorker coWorker) {
        coWorkerService.saveCoWorker(coWorker);
        return "redirect:/main";
    }

}
