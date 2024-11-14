package com.example.demo.controller;

import com.example.demo.entity.Registration;
import com.example.demo.payload.RegistrationDto;
import com.example.demo.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
public class ResgistrationController {

    private RegistrationService registrationService;

    public ResgistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegistration(){
        return "done";
    }

    @PostMapping
    public ResponseEntity<RegistrationDto> createRegistration(@RequestBody RegistrationDto registrationDto){
        RegistrationDto registration1 = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(registration1 , HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(@RequestParam long id){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Registration with record id" + id + "is deleted" , HttpStatus.OK);
    }

}
