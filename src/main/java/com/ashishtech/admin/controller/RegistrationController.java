package com.ashishtech.admin.controller;

import com.ashishtech.admin.entity.Registration;
import com.ashishtech.admin.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String listRegistrations(Model model) {
        model.addAttribute("registrations", registrationService.getAllRegistrations());
        return "registrations";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration_form";
    }

    @PostMapping
    public String saveRegistration(@ModelAttribute Registration registration) {
        registrationService.saveRegistration(registration);
        return "redirect:/registrations";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Registration registration = registrationService.getRegistration(id).orElseThrow();
        model.addAttribute("registration", registration);
        return "registration_form";
    }

    @PostMapping("/update/{id}")
    public String updateRegistration(@PathVariable Long id, @ModelAttribute Registration registration) {
        registration.setId(id);
        registrationService.saveRegistration(registration);
        return "redirect:/registrations";
    }

    @GetMapping("/delete/{id}")
    public String deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return "redirect:/registrations";
    }
}
