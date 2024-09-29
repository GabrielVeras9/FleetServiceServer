//CONTEUDO RELACIONADO A OCULTARCONTEUDOS
function ocultarConteudos(excecao) {
    const conteudos = [
        'conteudoMonitoracao',
        'conteudoSobreNos',
        'conteudoPesquisa',
        'conteudoCadastroFrota',
        'conteudoCadastroMotorista',
        'conteudoCriarRotas'
    ];

    conteudos.forEach(conteudo => {
        const elemento = document.getElementById(conteudo);
        if (conteudo !== excecao) {
            elemento.style.display = 'none';
        } else {
            elemento.style.display = 'block'; // Exibir o conteúdo desejado
        }
    });
}
//FIM CONTEUDO RELACIONADO A OCULTARCONTEUDOS


//CONTEUDO RELACIONADO A PESQUISA
function exibirConteudoPesquisa() {
    ocultarConteudos('conteudoPesquisa');
    const conteudo = `<input type="text" id="campoPesquisa" placeholder="Digite para pesquisar">
    <button onclick="pesquisar()">Pesquisar</button>
    <br>
    <br>
    <br>
    <table id="motoristaTable" class="espacamento">
        <thead>
            <tr>
                <th>Nome:</th>
                <th>Email:</th>
                <th>CPF:</th>
                <th>RG:</th>
                <th>CNH:</th>
                <th>CNH:</th>
                <th>Cep:</th>
                <th>Cidade:</th>
                <th>Bairro:</th>
                <th>Documento:</th>
            </tr>
        </thead>
        <tbody id="tableBody">
        </tbody>
    </table>`;


    // Coloque o conteúdo na área desejada da página, por exemplo, em um div com ID 'conteudoPesquisa'
    document.getElementById('conteudoPesquisa').innerHTML = conteudo;
}

function pesquisar() {
    var termoPesquisa = document.getElementById('campoPesquisa').value.toLowerCase();
    var url = `http://localhost:8080/preposto/motorista/nome/${termoPesquisa}`;

    var request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function() {
        if (request.status >= 200 && request.status < 400) {
            var responseData = JSON.parse(request.responseText);

            exibirMotoristas(responseData);
        } else {
            console.error('Erro ao carregar os dados.');
        }
    };

    request.onerror = function() {
        console.error('Erro de conexão.');
    };

    request.send();

}



function exibirMotoristas(motoristas) {
    var tableBody = document.getElementById('tableBody');
    tableBody.innerHTML = '';
    motoristas.forEach(function(motorista) {
        var row = tableBody.insertRow();
        var cellNome = row.insertCell(0);
        cellNome.innerHTML = motorista.nome_motorista;

        var cellEmail = row.insertCell(1); // Corrigindo a posição das células
        cellEmail.innerHTML = motorista.emailMotorista;

        var cellCPF = row.insertCell(2);
        cellCPF.innerHTML = motorista.cpf_motorista;

        var cellRG = row.insertCell(3);
        cellRG.innerHTML = motorista.rg_motorista;

        var cellCNH = row.insertCell(4);
        cellCNH.innerHTML = motorista.cnh_motorista;

        var cellTipoCNH = row.insertCell(5);
        cellTipoCNH.innerHTML = motorista.tipo_cnh;

        var cellCep = row.insertCell(6);
        cellCep.innerHTML = motorista.cep;

        var cellCidade = row.insertCell(7);
        cellCidade.innerHTML = motorista.cidade;

        var cellBairro = row.insertCell(8);
        cellBairro.innerHTML = motorista.bairro;

        var cellDocumento = row.insertCell(9);
        cellDocumento.innerHTML = `<a href="${motorista.doc_img}" target="_blank">Ver Documento</a>`;
    });
}

//CONTEUDO RELACIONADO A CADASTRO FROTA
function exibirConteudoCadastroFrota() {
    ocultarConteudos('conteudoCadastroFrota');
    const conteudo = /*`<body>
    <form id="veiculoForm" enctype="multipart/form-data">
        <p>Atenção: Preencha de acordo com os dados do seu veiculo.</p>
        <p>Se voce possuir mais de um veiculo, sera necessario cadastrar um por um, caso haja muitos veiculos, entre em contato conosco via email: fleet@fleetmanagement.com, e envie um anexo com os dados dos veiculos juntamente com os documentos para serem
            homologados no sistema!!!</p>

        <label for="tipo_veiculo">Tipo do Veículo:</label>
        <select id="tipo_veiculo" name="tipo_veiculo" required>
            <option value="" selected disabled>Selecione o tipo de veículo</option>
            <option value="A">Motocicleta</option>
            <option value="B">Veículo de passeio</option>
            <option value="C">Veículo de carga</option>
            <option value="D">Transporte de passageiros</option>
            <option value="E">Combinação de veículos</option>
        </select><br><br>

        <label for="marca_veiculo">Marca:</label>
        <select id="marca_veiculo" name="marca_veiculo" required>
            <option value="" disabled selected>Selecione uma marca</option>
            <option value="Chevrolet">Chevrolet</option>
            <option value="Fiat">Fiat</option>
            <option value="Volkswagen">Ford</option>
            <option value="Volkswagen">Volkswagen</option>
            <option value="Volkswagen">Renault</option>
            <option value="Volkswagen">Nissan</option>
            <option value="Volkswagen">Toyota</option>
            <option value="Volkswagen">Hyundai</option>
        </select><br><br>

        <label for="modelo_veiculo">Modelo:</label>
        <input type="text" id="modelo_veiculo" name="modelo_veiculo" required><br><br>

        <label for="ano_fabricacao">Ano de Fabricação/Modelo:</label>
        <input type="text" id="ano_fabricacao" name="ano_fabricacao" required pattern="\d{4}/\d{4}" title="Formato válido: YYYY/YYYY" placeholder="Exemplo: 2019/2020"><br><br>

        <label for="cor_veiculo">Cor do Veiculo:</label>
        <input type="text" id="cor_veiculo" name="cor_veiculo" required style="text-transform: uppercase;"><br><br>

        <label for="renavam">Renavam:</label>
        <input type="text" id="renavam" name="renavam" required pattern="[0-9]*" title="Apenas números são permitidos"><br><br>

        <label for="num_placa">Número da Placa:</label>
        <input type="text" id="num_placa" name="num_placa" required style="text-transform: uppercase;"><br><br>

        <label for="cep_veiculo">CEP:</label>
        <input type="text" id="cep_veiculo" name="cep_veiculo" required onchange="buscaCep('veiculo')" required pattern="[0-9]*" title="Apenas números são permitidos"><br><br>

        <label for="cidade_veiculo">Cidade:</label>
        <input type="text" id="cidade_veiculo" name="cidade_veiculo" style="background-color: rgb(100, 100, 100); color: white;" required readonly><br><br>


        <label for="bairro_veiculo">Bairro:</label>
        <input type="text" id="bairro_veiculo" name="bairro_veiculo" style="background-color: rgb(100, 100, 100); color: white;" required readonly><br><br>

        <p>Anexa logo aqui abaixo o PDF ou a foto do CRLV (CERTIFICADO DE REGISTRO E LICENCIAMENTO DO VEICULO).</p>
        <label for="doc_veiculo">Documento:</label>
        <input type="file" id="doc_veiculo"><br><br>

        <!--<label for="ativo">Deseja ativar o veiculo? </label>
        <input type="checkbox" id="veiculo_ativo" name="ativo" checked><br><br>-->

        <button type="submit">Cadastrar</button>
    </form>
</body>`;
*/
    // Coloque o conteúdo na área desejada da página, por exemplo, em um div com ID 'conteudoCadastroFrota'
    document.getElementById('conteudoCadastroFrota').innerHTML = conteudo;
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
    
    
}
//FIM DO CONTEUDO RELACIONADO A PESQUISA

//CONTEUDO RELACIONADO A CADASTRO MOTORISTAS
function exibirConteudoCadastroMotorista() {
    ocultarConteudos('conteudoCadastroMotorista');
    const conteudo = `<form id="cadastroForm" enctype="multipart/form-data">
    <h4>Preencha apenas com os dados do seu motoristas: </h4>
     <label for="nome_motorista">Nome:</label>
     <input type="text" id="nome_motorista" name="nome_motorista" required pattern="[A-Za-zÀ-ú ]*" title="Apenas letras são permitidas"><br><br>
     
     <label for="email_motorista">Email:</label>
     <input type="text" id="email_motorista" name="email_motorista" required><br><br>
     
     <label for="cpf_motorista">CPF:</label>
     <input type="text" id="cpf_motorista" name="cpf_motorista" required pattern="[0-9]*" title="Apenas números são permitidos"><br><br>
     <label for="rg_motorista">RG:</label>
     <input type="text" id="rg_motorista" name="rg_motorista" required pattern="[0-9]*" title="Apenas números são permitidos"><br><br>
     <label for="tipo_cnh_motorista">Tipo da CNH:</label>
 <select id="tipo_cnh_motorista" name="tipo_cnh_motorista" required>
     <option value="" selected disabled>Selecione o tipo de CNH</option>
     <option value="A">A - Motocicleta</option>
     <option value="B">B - Veículo de passeio</option>
     <option value="C">C - Veículo de carga</option>
     <option value="D">D - Transporte de passageiros</option>
     <option value="E">E - Combinação de veículos</option>
 </select><br><br>
     <label for="cnh_motorista">CNH:</label>
     <input type="text" id="cnh_motorista" name="cnh_motorista" required pattern="[0-9]*" title="Apenas números são permitidos"><br><br>
     <!-- Endereço do Motorista -->
     <label for="cep_motorista">CEP:</label>
     <input type="text" id="cep_motorista" name="cep_motorista" required onchange="buscaCep('motorista')" required pattern="[0-9]*" title="Apenas números são permitidos"><br><br>
     <label for="cidade_motorista">Cidade:</label>
     <input type="text" id="cidade_motorista" name="cidade_motorista" style="width: 150px; background-color: rgb(100, 100, 100); color: white;" required readonly><br><br>
     <label for="bairro_motorista">Bairro:</label>
     <input type="text" id="bairro_motorista" name="bairro_motorista" style="width: 150px; background-color: rgb(100, 100, 100); color: white;" required readonly><br><br>
     <!-- Documento do Motorista -->
     <p>Selecione o periodo em que o motorista ira fazer essa rota</p>
        <label for="inicio_rota">Início da Rota:</label>
		<input type="datetime-local" id="inicio_rota" name="inicio_rota" required><br><br>
		
		<label for="fim_rota">Fim da Rota:</label>
		<input type="datetime-local" id="fim_rota" name="fim_rota" required><br><br>
		
		<!--<label for="hora_prevista">Hora Prevista:</label>
		<input type="time" id="hora_prevista" name="hora_prevista" required><br><br>-->
     <label for="doc_img_motorista">Documento:</label>
     <input type="file" id="doc_img_motorista"><br><br>
     
     <p>ATENÇÃO: Aqui esta disponiveis apenas os veiculo que voce marcou como ATIVOS</p>
     <h4>Pesquise o veiculo cadastrado pela placa:</h4>
     <label for="num_placa">Número da Placa:</label>
     <input id="num_placa" name="num_placa" style="width: 150px;" required onchange="buscaModeloVeiculo()"><br><br>
     
     <label for="marca_veiculo">Marca:</label>
     <input id="marca_veiculo" name="marca_veiculo" style="width: 150px; background-color: rgb(100, 100, 100); color: white;" required readonly><br><br>
     
     <label for="modelo_veiculo">Modelo:</label>
     <input id="modelo_veiculo" name="modelo_veiculo" style="width: 150px; background-color: rgb(100, 100, 100); color: white;" required readonly><br><br>
     
     <label for="ano_fabricacao">Ano de Fabricação:</label>
     <input id="ano_fabricacao" name="ano_fabricacao" style="width: 150px; background-color: rgb(100, 100, 100); color: white;" required readonly><br><br>
     
     <label for="cor_veiculo">Cor do Veiculo:</label>
     <input id="cor_veiculo" name="cor_veiculo" style="width: 150px; background-color: rgb(100, 100, 100); color: white;" required readonly><br><br>

 
 
 <p>Apos finalizar o cadastro, sera encaminhado para o email do motorista a suas credenciais (Email e Senha) para acessar o aplicativo da FleetApp.</p>

 <button type="submit">Cadastrar</button>`;
    // Coloque o conteúdo na área desejada da página, por exemplo, em um div com ID 'conteudoCadastroMotorista'
    document.getElementById('conteudoCadastroMotorista').innerHTML = conteudo;
}

//FIM CONTEUDO RELACIONADO A CADASTRO MOTORISTAS

//CONTEUDO RELACIONADO A CRIAR ROTAS
function exibirConteudoCriarRotas() {
    ocultarConteudos('conteudoCriarRotas');
    const conteudo = `
        
        <div id="routeDetails">
            <ul>
                <li><b>Extensão (km):</b> <span id="routeDistance"></span></li>
                <li><b>Tempo Médio:</b> <span id="routeTime"></span></li>
            </ul>
            <div id="map"></div>
        </div>
        <button id="saveRoute">Salvar Coordenadas do Percurso</button>
        `;

    document.getElementById('conteudoCriarRotas').innerHTML = conteudo;

    // Carregar mapa e funcionalidades do mapa aqui após inserir o conteúdo HTML na página
    var map = L.map('map').setView([-15.8267, -47.9218], 12);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    var control = L.Routing.control({
        waypoints: [
            L.latLng(-15.8267, -47.9218),
            L.latLng(-15.8506, -47.9292) // Exemplo de um segundo ponto
        ],
        routeWhileDragging: true
    }).addTo(map);

    var coordinates = []; // Array para armazenar as coordenadas do percurso
    var routeSummary = {
        distance: 0,
        time: 0
    };

    control.on('routesfound', function(e) {
        var route = e.routes[0].coordinates;
        coordinates = route.map(coordinate => ({
            lat: coordinate.lat,
            lng: coordinate.lng
        }));

        routeSummary.distance = e.routes[0].summary.totalDistance / 1000; // Convertendo metros para quilômetros
        routeSummary.time = e.routes[0].summary.totalTime;

        document.getElementById('routeDistance').innerText = routeSummary.distance.toFixed(2) + ' km';
        document.getElementById('routeTime').innerText = Math.floor(routeSummary.time / 60) + ' minutos';
    });

    document.getElementById('saveRoute').addEventListener('click', function() {
        var dataToSave = {
            coordinates: coordinates,
            distance: routeSummary.distance.toFixed(2) + ' km',
            time: Math.floor(routeSummary.time / 60) + ' minutos'
        };

        fetch('/api/rota/salvar', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToSave)
            })
            .then(response => response.json())
            .then(data => {
                console.log('Dados da rota salvos no backend:', data);
            })
            .catch(error => {
                console.error('Erro ao salvar os dados da rota:', error);
            });
    });
}
//FIM CONTEUDO RELACIONADO A CRIAR ROTAS

function exibirConteudoSobreNos() {
    ocultarConteudos('conteudoSobreNos');
    const conteudo = ` <main id="conteudo-aplicativo">
			    <br>
			    <br>
			    <br>
        <section class="chamada__aplicativo">
            <h2 class="aplicativo__titulo">Faça o rastreio do seu veículo usando FleetAPP</h2>
            <p class="aplicativo__texto">Com o aplicativo FleetApp você pode rastrear os seus motoristas em tempo real e saber das rotas realizadas. Disponível para Android e iOS. <strong class="texto-destaque"></strong></p>
            <div class="store-and-qr">
                <div class="store-info">
                    <img src="/img/DisponivelGooglePlay.png" alt="Disponível na Play Store" class="play-store-image">
                    <a href="https://play.google.com" class="aplicativo__button app__download--android botao">Android</a>
                </div>
                <div class="qr-code-info">
                    <img src="/img/qrcode_chrome.png" alt="QR Code Android" class="qr-code-android">
                </div>
            </div>
            <div class="store-and-qr">
                <div class="store-info">
                    <img src="/img/DisponívelNaAppStore.png" alt="Disponível na App Store" class="app-store-image">
                    <a href="https://apps.apple.com" class="aplicativo__button app__download--ios botao">iOS</a>
                </div>
                <div class="qr-code-info">
                    <img src="/img/qrcode_chrome.png" alt="QR Code iOS" class="qr-code-ios">
                </div>
            </div>
        </section>
    <br>
    <br>
    <br>
         <p>Faça o <span class="destacado-download">Download</span> das documentações da Fleet:</p>
    <ul class="document-list">
        <li>
            <span class="doc-title">Manual Aplicativo:</span>
            <a href="https://drive.google.com/file/d/1B2NAT_mdFaTlqYCZOb6CMSqFRCUmBRF4/view?usp=drive_link" class="download-link" target="_blank">Download</a>
        </li>
        <li>
            <span class="doc-title">Manual Sistema Web:</span>
            <a href="https://drive.google.com/file/d/10zhiZqF9uGMLCFHw9pw-j5hnJsl8HhjA/view?usp=drive_link" class="download-link" target="_blank">Download</a>
        </li>
        <li>
            <span class="doc-title">Serviços pagos:</span>
            <a href="https://drive.google.com/file/d/1LaRPe59_OFWxE2nSBE5GMiwNOCYNRVyz/view?usp=drive_link" class="download-link" target="_blank">Download</a>
        </li>
    </ul>
    </main>
    <br>
     <footer>
        <p>Problemas com o sistema, documentações ou dúvidas? Encaminhe um e-mail para o <span class="destacado">suporte</span>.</p>
        <a href="/html/email.html" class="botao-suporte">Contate o Suporte</a>
    </footer>`;
    document.getElementById('conteudoSobreNos').innerHTML = conteudo;
}
