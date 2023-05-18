package com.example.HospitalTokensGenerator.Controllers;

import com.example.HospitalTokensGenerator.DTOs.TokenEntryDto;
import com.example.HospitalTokensGenerator.Repositories.TokenRepository;
import com.example.HospitalTokensGenerator.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @PostMapping("/add")
    public ResponseEntity<String> createToken(@RequestBody TokenEntryDto tokenEntryDto) {
        try {
            String respone = tokenService.createToken(tokenEntryDto);
            return new ResponseEntity<>(respone, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
