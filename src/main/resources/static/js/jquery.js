$(function() {

	$('.main').on('click', '#btn-salvar', function(event) {
		var json = {
			nome: $('#nomePessoa').val(),
			email: $('#emailPessoa').val(),
			cpf: $('#cpfPessoa').val(),
			enderecodto: {
				cep: $('#cepPessoa').val(),
				logradouro: $('#logradouroEndereco').val(),
				numero: $('#numeroEndereco').val(),
				complemento: $('#complementoEndereco').val(),
				bairro: $('#bairroEndereco').val(),
				cidade: $('#cidadeEndereco').val(),
				uf: $('#ufEndereco').val()
			}
			
		};
		console.log(JSON.stringify(json));
		$.ajax({
			type: "post",
			url: 'pessoas',
			contentType: "application/json",
			data: JSON.stringify(json),
			success: function(retorno) {
				alert(retorno + " alterado com sucesso!");
				$('.main').load('listar.html');
				listarPessoas();
			}});
			event.preventDefault();
		}); 
//			//done é chamado depois que voltou do servidor (callback)
//			.done(function (retorno) { 
//				alert('mensagem do servidor ' + retorno);
//				$('.main').load('listar.html');
//				listarPessoas();
//
//			});
		
	
	$('.main').on('blur', '#cepPessoa', function(event) {
		
		$.get('https://viacep.com.br/ws/' + $(this).val() + '/json/', function(data) {
			if(!("erro" in data)){
				$('#logradouroEndereco').val(data.logradouro);
				$('#bairroEndereco').val(data.bairro);
				$('#cidadeEndereco').val(data.localidade);
				$('#ufEndereco').val(data.uf);
			}
			else {
				$('#logradouroEndereco').val("");
				$('#bairroEndereco').val("");
				$('#cidadeEndereco').val("");
				$('#ufEndereco').val("");
				alert("CEP não encontrado")
			}
		});
		event.preventDefault();
	});
	$('#btn-cadastrar').click(function() {
		$('.main').load('cadastrar.html');
		$('#modoCadastro').html('Cadastro de Pessoa Física');
	});
	$('#btn-listar').click(function() {
		$('.main').load('listar.html', function() {
			listarPessoas();
			
			
		});
		
	});

	$('.main').on('click', '.btn-excluir', function(event) {
		var cpfAtual =  $(this).siblings('.cpfPessoa').html();
		
		
		
		console.log(cpfAtual);
		$.ajax({
			url: 'pessoas/' + cpfAtual,
			data: cpfAtual,
			dataType: 'text',
			method: 'delete',
			success: function (response) {
				alert("cpf: " + response + " deletado com sucesso");
				$('.main').load('listar.html');
				listarPessoas();
			}
		});
		
		event.preventDefault();
	});
	$('.main').on('click', '.btn-alterar', function(event) {
		var cpfAtual = $(this).siblings('.cpfPessoa').html();
		$('.main').load('cadastrar.html');
		$.get("pessoas/" + cpfAtual, function (data) { 
			console.log(cpfAtual);
			console.log(data.nome);
			console.log(data.enderecodto.cidade);
			$('#modoCadastro').html('Alterar cadastro de Pessoa Física');
			$('#nomePessoa').val(data.nome);
			$('#emailPessoa').val(data.email);
			$('#cpfPessoa').val(data.cpf).prop('disabled', true);
			$('#cepPessoa').val(data.enderecodto.cep);
			$('#numeroEndereco').val(data.enderecodto.numero);
			$('#complementoEndereco').val(data.enderecodto.complemento);
			$('#logradouroEndereco').val(data.enderecodto.logradouro);
			$('#bairroEndereco').val(data.enderecodto.bairro);
			$('#cidadeEndereco').val(data.enderecodto.cidade);
			$('#ufEndereco').val(data.enderecodto.uf);
			},
			"json"
		);

		event.preventDefault();
	});
	
});

function listarPessoas() {
	$.get('buscar5', function (data) {
		console.log(data);
		data.forEach(clima => {
			var tdNome = $('<td></td>').html(pessoa.nome);
			var tdCpf = $('<td></td>').html(pessoa.cpf).addClass('cpfPessoa');
			var tdEmail = $('<td></td>').html(pessoa.email);
			var tdCep = $('<td></td>').html(pessoa.enderecodto.cep);
			var tdLogradouro = $('<td></td>').html(pessoa.enderecodto.logradouro);
			var tdNumero = $('<td></td>').html(pessoa.enderecodto.numero);
			var tdComplemento = $('<td></td>').html(pessoa.enderecodto.complemento);
			var tdBairro = $('<td></td>').html(pessoa.enderecodto.bairro);
			var tdCidade = $('<td></td>').html(pessoa.enderecodto.cidade);
			var tdUf = $('<td></td>').html(pessoa.enderecodto.uf);
			var botaoExcluir = $('<button></button>').html('Excluir').addClass('btn-excluir');
			var botaoAlterar = $('<button></button>').html('Alterar').addClass('btn-alterar');
			var tr = $('<tr><form></form></tr>').append(tdNome).append(tdCpf).append(tdEmail).append(tdCep).append(tdLogradouro).append(tdNumero).append(tdComplemento).append(tdBairro).append(tdCidade).
				append(tdUf).append(botaoAlterar).append(botaoExcluir);
			$('#corpoTabela').append(tr);
		});
	});


}

