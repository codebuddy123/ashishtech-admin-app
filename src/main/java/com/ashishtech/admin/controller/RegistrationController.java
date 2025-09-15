package com.ashishtech.admin.controller;

import com.ashishtech.admin.entity.Registration;
import com.ashishtech.admin.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String listRegistrations(Model model, HttpServletRequest request) {
        model.addAttribute("registrations", registrationService.getAllRegistrations());
        // Get client IP
        String clientIp = request.getRemoteAddr();
        // Get server IP
        String serverIp = "Unknown";
        try {
            serverIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            // leave as Unknown
        }
        model.addAttribute("clientIp", clientIp);
        model.addAttribute("serverIp", serverIp);
        return "registrations";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration_form";
    }

    @PostMapping
    public String saveRegistration(@Valid @ModelAttribute Registration registration, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("registration", registration);
            return "registration_form";
        }
        registrationService.saveRegistration(registration);
        return "redirect:/registrations/thankyou";
    }
    @GetMapping("/thankyou")
    public String showThankYouPage() {
        return "thankyou";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Registration registration = registrationService.getRegistration(id).orElseThrow();
        model.addAttribute("registration", registration);
        return "registration_form";
    }

    @PostMapping("/update/{id}")
    public String updateRegistration(@PathVariable Long id, @Valid @ModelAttribute Registration registration, BindingResult result, Model model) {
        if (result.hasErrors()) {
            registration.setId(id);
            model.addAttribute("registration", registration);
            return "registration_form";
        }
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
