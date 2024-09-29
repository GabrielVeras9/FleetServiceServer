package br.com.fleetmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fleetmanagement.DTO.UoscDTO;
import br.com.fleetmanagement.entity.Contrato;
import br.com.fleetmanagement.entity.Operador;
import br.com.fleetmanagement.entity.Servico;
import br.com.fleetmanagement.entity.Usuario;
import br.com.fleetmanagement.repository.ContratoRepository;
import br.com.fleetmanagement.repository.OperadorRepository;
import br.com.fleetmanagement.repository.ServicoRepository;
import br.com.fleetmanagement.repository.UsuarioRepository;

@Service
public class UoscService {
	@Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OperadorRepository operadorRepository;
    
    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ContratoRepository contratoRepository;
    
    public void cadastrarUsuario(UoscDTO dto) {
    	Usuario usuario = new Usuario();
    	usuario.setNom_usuario(dto.getNom_usuario());
    	usuario.setSen_usuario(dto.getSen_usuario());
    	usuario.setemail(dto.getEmail());
    	usuario.setCpf_usuario(dto.getCpf_usuario());
    	usuario.setRg_usuario(dto.getRg_usuario());
    	usuario.setCep(dto.getCep());
    	usuario.setCidade(dto.getCidade());
    	usuario.setBairro(dto.getBairro());
    	usuarioRepository.save(usuario);
    	
    	Operador operador = new Operador();
    	operador.setNom_razao_social(dto.getNom_razao_social());
    	operador.setCnpj_operador(dto.getCnpj_operador());
    	operadorRepository.save(operador);
    	
    	Servico servico = new Servico();
    	servico.setDesc_servico(dto.getDesc_servico());
    	servico.setNom_servico(dto.getNom_servico());
    	servicoRepository.save(servico);
    	
    	Contrato contrato = new Contrato();
    	contrato.setNum_contrato(dto.getNum_contrato());
    	contrato.setIni_vigencia(dto.getIni_vigencia());
    	contrato.setFim_vigencia(dto.getFim_vigencia());
    	contrato.setDoc_contrato(dto.getDoc_contrato());
    	contratoRepository.save(contrato);	
    }
}
