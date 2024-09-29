package br.com.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestController {
	
	@GetMapping("/login")
    public String redirectToLogin() {
        return "redirect:/html/login.html";
    }
	
	@GetMapping("/login/registrar")
    public String redirectToRegistat() {
        return "redirect:/html/registrar.html";
    }
	@GetMapping("/index")
    public String redirectToIndex() {
        return "redirect:/html/index.html";
    }
	
}

