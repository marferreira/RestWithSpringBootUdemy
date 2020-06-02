package br.com.erudio.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.modelo.Pessoa;
import br.com.erudio.servicos.PessoaServicos;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaServicos pessoaServicos;
	
	@GetMapping
	public List<Pessoa> finAll(){
		return pessoaServicos.FindAll();
	}
	
	@GetMapping("/{id}")
	public Pessoa finById(@PathVariable("id") Long id){
		return pessoaServicos.FindById(id);
	}
	
	@PostMapping
	public Pessoa create(@RequestBody Pessoa pessoa){
		return pessoaServicos.create(pessoa);
	}
	
	@PutMapping
	public Pessoa update(@RequestBody Pessoa pessoa){
		return pessoaServicos.update(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		 pessoaServicos.delete(id);
		 return ResponseEntity.ok().build();
	}
	
}
