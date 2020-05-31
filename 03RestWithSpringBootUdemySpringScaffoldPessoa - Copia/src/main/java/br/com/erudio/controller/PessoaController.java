package br.com.erudio.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.modelo.Pessoa;
import br.com.erudio.servicos.PessoaServicos;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaServicos pessoaServicos;
	
	@RequestMapping(method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> finAll(){
		return pessoaServicos.FindAll();
	}
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Pessoa finById(@PathVariable("id") String id){
		return pessoaServicos.FindById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE )
	public Pessoa create(@RequestBody Pessoa pessoa){
		return pessoaServicos.create(pessoa);
	}
	
	@RequestMapping(method=RequestMethod.PUT, 
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE )
	public Pessoa update(@RequestBody Pessoa pessoa){
		return pessoaServicos.update(pessoa);
	}
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Long id){
		 pessoaServicos.delete(id);
	}
	

	
}
