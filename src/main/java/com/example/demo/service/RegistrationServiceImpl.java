package com.example.demo.service;

import com.example.demo.entity.Registration;
import com.example.demo.payload.RegistrationDto;
import com.example.demo.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl  implements RegistrationService{

    private RegistrationRepository registrationRepo;

    public RegistrationServiceImpl(RegistrationRepository registrationRepo) {
        this.registrationRepo = registrationRepo;
    }


    @Override
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
        Registration registration = mapToEntity(registrationDto);
                Registration savedEntity = registrationRepo.save(registration);
        RegistrationDto dto = mapToDto(savedEntity);
        return dto;
    }

    @Override
    public void deleteRegistration(long id) {
        registrationRepo.deleteById(id);
    }

    Registration mapToEntity(RegistrationDto dto){
        Registration entity = new Registration();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());
        return entity;
    }
    RegistrationDto mapToDto (Registration registration){
        RegistrationDto dto = new RegistrationDto();
        dto.setId(registration.getId());
        dto.setName(registration.getName());
        dto.setEmail(registration.getEmail());
        dto.setMobile(registration.getMobile());
        return dto;
    }
}
