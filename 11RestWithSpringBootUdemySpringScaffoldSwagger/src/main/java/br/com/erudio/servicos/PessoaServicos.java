package br.com.erudio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.modelo.Pessoa;
import br.com.erudio.data.vo.PessoaVO;
import br.com.erudio.exception.ResourcesNotFoundException;
import br.com.erudio.repository.PessoaRepository;

@Service
public class PessoaServicos {
	
	@Autowired
	PessoaRepository pessoaRepository; 
	
	public PessoaVO create(PessoaVO pessoa) {
		var entity = DozerConverter.parseObject(pessoa, Pessoa.class);
		var vo = DozerConverter.parseObject(pessoaRepository.save(entity), PessoaVO.class);
		return vo;
	}
	
	public PessoaVO update(PessoaVO pessoa) {
		
		var entity = pessoaRepository.findById(pessoa.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setPrimeiroNome(pessoa.getPrimeiroNome());
		entity.setSegundoNome(pessoa.getSegundoNome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setSexo(pessoa.getSexo());
		
		var vo = DozerConverter.parseObject(pessoaRepository.save(entity), PessoaVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Pessoa pes = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado pelo ID"));
		
		pessoaRepository.delete(pes);
	}
	
	public List<PessoaVO> findAll() {
		return DozerConverter.parseListObjects(pessoaRepository.findAll(), PessoaVO.class);
	}
	
	public PessoaVO findById(Long id) {
		var entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado pelo ID"));
		return DozerConverter.parseObject(entity, PessoaVO.class);
	}

	
	
}
