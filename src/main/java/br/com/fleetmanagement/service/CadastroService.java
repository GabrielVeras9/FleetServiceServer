package br.com.fleetmanagement.service;

import java.security.SecureRandom;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.fleetmanagement.DTO.MotoAndVeiDTO;
import br.com.fleetmanagement.entity.Preposto;
import br.com.fleetmanagement.entity.VeiPorMotorista;
import br.com.fleetmanagement.repository.PrepostoRepository;
import br.com.fleetmanagement.repository.VeiPorMotoristaRepository;
import ch.qos.logback.classic.Logger;
import jakarta.mail.internet.MimeMessage;

@Service
public class CadastroService {

    @Autowired
    private VeiPorMotoristaRepository veiPorMotoristaRepository;

    @Autowired
    private PrepostoRepository prepostoRepository;
    
    @Autowired
    private GoogleDriveService googleDriveService;
    
    @Autowired
    private JavaMailSender emailSender;
    
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CadastroService.class);
    
    //Salva os arquivos de imagem no google drive//
    public String uploadFileToDrive(MultipartFile file) {
        try {

            String linkGoogleDrive = googleDriveService.uploadFileToDrive(file);
            return linkGoogleDrive;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //gerador de senha aleatoria//
    private String gerarSenhaAleatoria() {
        String caracteres = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        SecureRandom random = new SecureRandom();
        StringBuilder senha_motorista = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            senha_motorista.append(caracteres.charAt(index));
        }

        return senha_motorista.toString();
    }
    
    //Função para encaminhar o email assim que o login pro realizado com sucesso//
    private void enviarEmailBoasVindas(String email, String nomeMotorista, String senha_Motorista) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email);
            helper.setSubject("Bem-vindo à FleetApp Motorista - Seu Acesso ao Aplicativo");
        
        String bodyEmail = "<html><body>" +
                    "<p>Caro " + nomeMotorista + ",</p>" +
                    "<p>É um prazer tê-lo(a) como parte da equipe da FleetManagement!</p>" +
                    "<p>Para facilitar seu acesso ao aplicativo FleetApp, aqui estão suas credenciais de login:</p>" +
                    "<p>Email: " + email + " </p>" +
                    "<p>Senha: " + senha_Motorista + "</p>" +
                    "<p>Para garantir a segurança de sua conta, recomendamos que você altere sua senha assim que fizer o login pela primeira vez.</p>" +
                    "<p>Para acessar o aplicativo FleetManagement e começar, siga estas simples etapas:</p>" +
                    "<ul>" +
                    "<li>Baixe o aplicativo FleetManagement na App Store ou Google Play Store.</li>" +
                    "<li>Insira seu email e senha quando solicitado.</li>" +
                    "<li>Siga as instruções na tela para concluir a configuração inicial.</li>" +
                    "</ul>" +
                    "<p>Estamos ansiosos para trabalhar com você e tornar esta jornada conosco uma experiência produtiva e gratificante.</p>" +
                    "<p>Se tiver alguma dúvida ou precisar de assistência, nossa equipe de suporte estará pronta para ajudar. Não hesite em nos contatar através do e-mail gabrielveras@fleetmanagement.com ou pelo telefone (61) 0000-0000.</p>" +
                    "<p>Obrigado por escolher a FleetManagement. Estamos ansiosos para uma parceria bem-sucedida!</p>" +
                    "<p>Atenciosamente, Equipe FleetManagement</p>" +
                    "</body></html>";

	         helper.setText(bodyEmail, true);

	        emailSender.send(message);
	        logger.info("E-mail de confirmação de cadastro enviado para: {}", email);
	    } catch (MailException ex) {
	        logger.error("Erro ao enviar e-mail de confirmação de cadastro para: {}", email, ex);
	    } catch (Exception e) {
	        logger.error("Outro erro ao enviar e-mail de confirmação de cadastro para: {}", email, e);
	    }
	}
    
    public void cadastrarVeiculoEPreposto(MotoAndVeiDTO dto, MultipartFile file) {
        Preposto preposto = new Preposto();
        preposto.setEmailMotorista(dto.getEmailMotorista());
        String senhaAleatoria = gerarSenhaAleatoria();
        preposto.setSenha_motorista(senhaAleatoria);
        preposto.setNome_motorista(dto.getNome_motorista());
        preposto.setCpf_motorista(dto.getCpf_motorista());
        preposto.setRg_motorista(dto.getRg_motorista());
        preposto.setCnh_motorista(dto.getCnh_motorista());
        preposto.setTipo_cnh(dto.getTipo_cnh());
        preposto.setCep(dto.getCep());
        preposto.setCidade(dto.getCidade());
        preposto.setBairro(dto.getBairro());
        
        VeiPorMotorista veiPorMotorista = new VeiPorMotorista();
        veiPorMotorista.setMarca(dto.getMarca());
        veiPorMotorista.setModelo(dto.getModelo());
        veiPorMotorista.setNum_placa(dto.getNum_placa());
        veiPorMotorista.setCor_veiculo(dto.getCor_veiculo());
        veiPorMotorista.setFabricacao(dto.getFabricacao());
        veiPorMotorista.setInicio_rota(dto.getInicio_rota());
        veiPorMotorista.setFim_rota(dto.getFim_rota());
        veiPorMotoristaRepository.save(veiPorMotorista);
        
        
        try {
            String linkGoogleDrive = googleDriveService.uploadFileToDrive(file);
            preposto.setDoc_img(linkGoogleDrive);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        prepostoRepository.save(preposto);
        enviarEmailBoasVindas(dto.getEmailMotorista(), dto.getNome_motorista(), dto.getSenha_motorista());
    }
}
