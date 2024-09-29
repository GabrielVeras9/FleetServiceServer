package br.com.fleetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.fleetmanagement.service.GoogleDriveService;

@RestController
@RequestMapping("/documentos")
public class GoogleDriveController {

    @Autowired
    private GoogleDriveService googleDriveService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocumento(@RequestParam("file") MultipartFile file) {
        String link = googleDriveService.uploadFileToDrive(file);
        return ResponseEntity.ok().body("{\"link\": \"" + link + "\"}");
    }
}


