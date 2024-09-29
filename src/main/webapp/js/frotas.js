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
                 if (tipo === 'veiculo') {
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
     const form = document.getElementById('veiculoForm');
     form.addEventListener('submit', async(event) => {
         event.preventDefault();

         const formData = new FormData();
         const fileInput = document.getElementById('doc_veiculo');
         const file = fileInput.files[0];

         const dataObject = {
			 cat_veiculo: document.getElementById('tipo_veiculo').value,
			 
             modelo: document.getElementById('modelo_veiculo').value,
             
             marca: document.getElementById('marca_veiculo').value,
             
             ano_fabricacao: document.getElementById('ano_fabricacao').value,
             
             cor_veiculo: document.getElementById('cor_veiculo').value,
             
             renavam: document.getElementById('renavam').value,
             
             num_placa: document.getElementById('num_placa').value,
             
             cepvei: document.getElementById('cep_veiculo').value,
             
             cidadevei: document.getElementById('cidade_veiculo').value,
             
             bairrovei: document.getElementById('bairro_veiculo').value
             
             //veiculo_ativo: document.getElementById('veiculo_ativo').value
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
             const doc_veiculo = uploadData.link;

             const veiculoPrepostoResponse = await fetch('/veiculo/cadastrado/frota/veicular', {
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