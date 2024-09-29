 //EndPoint para Veiculos
function buscaModeloVeiculo() {
    const numPlaca = document.getElementById('num_placa').value;

    fetch(`/veiculo/cadastrado/${numPlaca}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Erro ao buscar modelos de veículo');
            }
        })
        .then(data => {
            if (data.length > 0) {
                const veiculoEncontrado = data[0]; // Considerando que apenas um veículo será retornado

                document.getElementById('marca_veiculo').value = veiculoEncontrado.marca;
                document.getElementById('modelo_veiculo').value = veiculoEncontrado.modelo;
                document.getElementById('ano_fabricacao').value = veiculoEncontrado.ano_fabricacao;
                document.getElementById('cor_veiculo').value = veiculoEncontrado.cor_veiculo;
            } else {
                // Limpa os campos se nenhum veículo for encontrado
                document.getElementById('marca_veiculo').value = '';
                document.getElementById('modelo_veiculo').value = '';
                document.getElementById('ano_fabricacao').value = '';
                document.getElementById('cor_veiculo').value = '';
            }
        })
        .catch(error => {
            console.error(error.message);
        });
}
 //fim

 //VIA CEP API
 function buscaCep(tipo) {
     const cep = tipo === 'motorista' ? document.getElementById('cep_motorista').value : document.getElementById('cep_veiculo').value;
     const url = `https://viacep.com.br/ws/${cep}/json/`;

     fetch(url)
         .then(response => response.json())
         .then(data => {
             if (data.erro) {
                 alert('CEP não encontrado');
             } else {
                 if (tipo === 'motorista') {
                     document.getElementById('cidade_motorista').value = data.localidade;
                     document.getElementById('bairro_motorista').value = data.bairro;
                 } else if (tipo === 'veiculo') {
                     document.getElementById('cidade_veiculo').value = data.localidade;
                     document.getElementById('bairro_veiculo').value = data.bairro;
                 }
             }
         })
         .catch(error => {
             console.error('Erro:', error);
             alert('Erro ao buscar CEP. Tente novamente.');
         });
 }
 //fim
 
 //EndPoint para cadastro
	document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('cadastroForm');
    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        
        const formData = new FormData();
        const fileInput = document.getElementById('doc_img_motorista');
        const file = fileInput.files[0];
		
        const dataObject = {
            nome_motorista: document.getElementById('nome_motorista').value,
            emailMotorista: document.getElementById('email_motorista').value,
            cpf_motorista: document.getElementById('cpf_motorista').value,
            rg_motorista: document.getElementById('rg_motorista').value,
            cnh_motorista: document.getElementById('cnh_motorista').value,
            tipo_cnh: document.getElementById('tipo_cnh_motorista').value,
            cep: document.getElementById('cep_motorista').value,
            cidade: document.getElementById('cidade_motorista').value,
            bairro: document.getElementById('bairro_motorista').value,
            
            inicio_rota: document.getElementById('inicio_rota').value,
            fim_rota: document.getElementById('fim_rota').value,
            //*hr_prevista: document.getElementById('hora_prevista').value, 
     
            modelo: document.getElementById('modelo_veiculo').value,
            marca: document.getElementById('marca_veiculo').value,
            fabricacao: document.getElementById('ano_fabricacao').value,
           
            num_placa: document.getElementById('num_placa').value,
            cor_veiculo: document.getElementById('cor_veiculo').value
        };

        const jsonData = new FormData();
        jsonData.append('dto', new Blob([JSON.stringify(dataObject)], { type: 'application/json' }));
        formData.append('dto', jsonData.get('dto'));
        formData.append('file', file);

        try {
            const uploadResponse = await fetch('/documentos/upload', {
                method: 'POST',
                body: formData,
                
               
            });

            if (!uploadResponse.ok) {
                throw new Error('Erro ao enviar o arquivo.');
            }

            const uploadData = await uploadResponse.json();
            const doc_img = uploadData.link;

            const veiculoPrepostoResponse = await fetch('/cadastro/veiculo-preposto', {
                method: 'POST',
                body: formData,
                 
            });

            if (veiculoPrepostoResponse.ok) {
                alert('Cadastro realizado com sucesso!');
            } else {
                throw new Error('Erro ao cadastrar. Tente novamente.');
            }
        } catch (error) {
            alert('Erro ao cadastrar. Tente novamente.');
            console.error('Erro:', error);
        }
    });
});

//fim