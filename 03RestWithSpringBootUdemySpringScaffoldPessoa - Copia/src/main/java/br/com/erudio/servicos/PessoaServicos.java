package br.com.erudio.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.modelo.Pessoa;

@Service
public class PessoaServicos {
	
	private final AtomicLong contador = new AtomicLong();
	
	public Pessoa create(Pessoa pessoa) {
		return pessoa;
	}
	
	public Pessoa update(Pessoa pessoa) {
		return pessoa;
	}
	
	public void delete(Long id) {
		
	}
	
	public List<Pessoa> FindAll() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (int i = 0; i < 8; i++) {
			Pessoa pessoa = mockPessoa(i);
			pessoas.add(pessoa);
		}
		return pessoas;
	}
	
	public Pessoa FindById(String id) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(contador.incrementAndGet());
		pessoa.setPrimeiroNome("Marcio");
		pessoa.setSegundoNome("Ferreira");
		pessoa.setEndereco("Perdoes - Minas Gerais - Brasil");
		pessoa.setSexo("Masculino");
		
		return pessoa;
	}

	private Pessoa mockPessoa(int i) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(contador.incrementAndGet());
		pessoa.setPrimeiroNome("Marcio "+i);
		pessoa.setSegundoNome("Ferreira "+i);
		pessoa.setEndereco("Perdoes - Minas Gerais - Brasil "+i);
		pessoa.setSexo("Masculino");
		
		return pessoa;
	}
	
}
