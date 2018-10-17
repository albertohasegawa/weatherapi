$(function() {

	$('.main').on('click', '#btn-buscar', function(event) {
		var cidade = $('#cidadeEscolhida').val();
		var hora = $('#horaEscolhida').val();
			
		
			
		
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

