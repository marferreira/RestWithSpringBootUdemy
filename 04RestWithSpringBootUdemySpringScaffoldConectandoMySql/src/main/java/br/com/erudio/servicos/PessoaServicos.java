package br.com.erudio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourcesNotFoundException;
import br.com.erudio.modelo.Pessoa;
import br.com.erudio.repository.PessoaRepository;

@Service
public class PessoaServicos {
	
	@Autowired
	PessoaRepository pessoaRepository; 
	
	public Pessoa create(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa update(Pessoa pessoa) {
		
		Pessoa pes = pessoaRepository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado pelo ID"));
		
		pes.setPrimeiroNome(pessoa.getPrimeiroNome());
		pes.setSegundoNome(pessoa.getSegundoNome());
		pes.setEndereco(pessoa.getEndereco());
		pes.setSexo(pessoa.getSexo());
		
		return pessoaRepository.save(pes);
	}
	
	public void delete(Long id) {
		Pessoa pes = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado pelo ID"));
		
		pessoaRepository.delete(pes);
	}
	
	public List<Pessoa> FindAll() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa FindById(Long id) {
		return pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado pelo ID"));
	}

	
	
}
