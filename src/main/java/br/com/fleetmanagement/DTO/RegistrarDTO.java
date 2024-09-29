package br.com.fleetmanagement.DTO;

import br.com.fleetmanagement.enuns.UsuarioEnuns;

public record RegistrarDTO(String nom_usuario, String sen_usuario, String email, String cpf_usuario, String rg_usuario, String cep, String cidade, String bairro, UsuarioEnuns Role) {

}
