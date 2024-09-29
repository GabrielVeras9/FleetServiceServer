package br.com.fleetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.fleetmanagement.DTO.VeiculoDTO;
import br.com.fleetmanagement.entity.Veiculo;
import br.com.fleetmanagement.projection.VeiculoProjection;
import br.com.fleetmanagement.repository.VeiculoRepository;

@Service
public class CadastroVeiculoService {
	
	@Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private GoogleDriveService googleDriveService;
    
    public String uploadFileToDrive(MultipartFile file) {
        try {

            String linkGoogleDrive = googleDriveService.uploadFileToDrive(file);
            return linkGoogleDrive;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Transactional(readOnly = true)
	public List<VeiculoDTO> findAll(){
		List<Veiculo> result = veiculoRepository.findAll();
		return result.stream().map(x -> new VeiculoDTO(x)).toList();

	}
    
    public List<VeiculoDTO> findByNum(String num_placa){
		List<VeiculoProjection> result = veiculoRepository.searchByNum(num_placa);
		return result.stream().map(x -> new VeiculoDTO(x)).toList();
	}
    
    public void cadastrarFrota(VeiculoDTO dto, MultipartFile file) {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(dto.getModelo());
        veiculo.setMarca(dto.getMarca());
        veiculo.setAno_fabricacao(dto.getAno_fabricacao());
        veiculo.setRenavam(dto.getRenavam());
        veiculo.setCat_veiculo(dto.getCat_veiculo());
        veiculo.setNum_placa(dto.getNum_placa());
        veiculo.setCepVei(dto.getCepvei());
        veiculo.setCidadeVei(dto.getCidadevei());
        veiculo.setBairroVei(dto.getBairrovei());
        
        try {
            String linkGoogleDrive = googleDriveService.uploadFileToDrive(file);
            veiculo.setDoc_veiculo(linkGoogleDrive);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        veiculo.setCor_veiculo(dto.getCor_veiculo());
        veiculoRepository.save(veiculo);
    }
}






