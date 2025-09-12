package com.ashishtech.admin.service;

import com.ashishtech.admin.entity.Registration;
// import com.ashishtech.admin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    // private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations() {
    // return registrationRepository.findAll();
    return null;
    }

    public Optional<Registration> getRegistration(Long id) {
    // return registrationRepository.findById(id);
    return null;
    }

    public Registration saveRegistration(Registration registration) {
    // return registrationRepository.save(registration);
    return null;
    }

    public void deleteRegistration(Long id) {
    // registrationRepository.deleteById(id);
    }
}
