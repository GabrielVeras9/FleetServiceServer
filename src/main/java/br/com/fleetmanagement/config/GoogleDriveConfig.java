package br.com.fleetmanagement.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

@Configuration
public class GoogleDriveConfig {
	
	private static final String CREDENTIALS_FILE_PATH = "src/main/resources/credentials.json";

    @Bean
    public NetHttpTransport netHttpTransport() throws GeneralSecurityException, IOException {
        return GoogleNetHttpTransport.newTrustedTransport();
    }

    @Bean
    public JsonFactory jsonFactory() {
        return JacksonFactory.getDefaultInstance();
    }

    @Bean
    public GoogleCredentials googleCredentials() throws IOException {
        FileInputStream credentialsStream = new FileInputStream(CREDENTIALS_FILE_PATH);
        return GoogleCredentials.fromStream(credentialsStream).createScoped("https://www.googleapis.com/auth/drive");
    }

    @Bean
    public Drive driveService(NetHttpTransport httpTransport, JsonFactory jsonFactory, GoogleCredentials googleCredentials) {
        return new Drive.Builder(httpTransport, jsonFactory, new HttpCredentialsAdapter(googleCredentials))
                .setApplicationName("FleetManagement")
                .build();
    }
}
