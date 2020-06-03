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

import br.com.erudio.data.vo.PessoaVO;
import br.com.erudio.servicos.PessoaServicos;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaServicos pessoaServicos;
	
	@GetMapping(produces = {"application/json","application/xml", "application/x-yaml"})
	public List<PessoaVO> finAll(){
		return pessoaServicos.FindAll();
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO finById(@PathVariable("id") Long id){
		return pessoaServicos.FindById(id);
	}
	
	@PostMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO create(@RequestBody PessoaVO pessoa){
		return pessoaServicos.create(pessoa);
	}
	
	@PutMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO update(@RequestBody PessoaVO pessoa){
		return pessoaServicos.update(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		 pessoaServicos.delete(id);
		 return ResponseEntity.ok().build();
	}
	
}
