package br.com.fleetmanagement.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import br.com.fleetmanagement.entity.Preposto;

@Service
public class GoogleDriveService {

    private static final String FOLDER_ID = "1Xv3o3l0W2EW2ECv85fkkxQj7whiPCW52";

    @Autowired
    private Drive googleDriveService;

    public String uploadFileToDrive(MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                // Criando o arquivo no Google Drive
                com.google.api.services.drive.model.File driveFile = new File();
                driveFile.setName(file.getOriginalFilename());
                driveFile.setParents(Collections.singletonList(FOLDER_ID));

                // Lendo o conteúdo do arquivo
                InputStream inputStream = file.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] fileContent = outputStream.toByteArray();

                // Fazendo o upload para o Google Drive
                driveFile = googleDriveService.files().create(driveFile, new ByteArrayContent(file.getContentType(), fileContent))
                        .setFields("id")
                        .execute();

                String fileId = driveFile.getId();
                String linkDaImagem = "https://drive.google.com/uc?id=" + fileId;

                // Se necessário, associe o link ao Preposto
                Preposto preposto = new Preposto();
                preposto.setDoc_img(linkDaImagem);

                return linkDaImagem;
            } else {
                return "Por favor, selecione um arquivo para upload.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro durante o upload da imagem para o Google Drive: " + e.getMessage();
        }
    }
}
