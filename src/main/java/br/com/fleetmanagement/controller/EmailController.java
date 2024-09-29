package br.com.fleetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.EmailDTO;
import br.com.fleetmanagement.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailDTO dto) {
        String to = dto.getTo();
        String subject = dto.getSubject();
        String text = dto.getText();

        emailService.sendEmail(to, subject, text);

        return "E-mail enviado com sucesso para " + to;
    }
}

