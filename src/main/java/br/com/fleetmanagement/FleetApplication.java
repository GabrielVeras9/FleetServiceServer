package br.com.fleetmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class FleetApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(FleetApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FleetApplication.class, args);

        logDetalhesAutenticacao();
    }

    private static void logDetalhesAutenticacao() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            LOGGER.info("Usuário autenticado: {}", authentication.getName());

        } else {
            LOGGER.info("Nenhum usuário autenticado");
        }
    }
}
