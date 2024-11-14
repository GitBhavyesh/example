package com.example.demo.service;

import com.example.demo.entity.Registration;
import com.example.demo.payload.RegistrationDto;

public interface RegistrationService {

    public RegistrationDto createRegistration(RegistrationDto registrationDto);

    void deleteRegistration(long id);
}
