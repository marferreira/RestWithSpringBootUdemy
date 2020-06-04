package br.com.erudio.controller;



import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Pessoa endpoint", description = "Descrição para pessoa", tags = {"PessoaEndpoint"})
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaServicos pessoaServicos;
	
	@ApiOperation(value = "Procura todas os registros da Pessoa")
	@GetMapping(produces = {"application/json","application/xml", "application/x-yaml"})
	public List<PessoaVO> findAll(){
		List<PessoaVO> pessoa =  pessoaServicos.findAll();
		pessoa
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(PessoaController.class).findById(p.getKey())).withSelfRel()
				)
			);
		return pessoa;
	}
	
	@ApiOperation(value = "Procura o registros pelo ID da Pessoa")
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO findById(@PathVariable("id") Long id){
		PessoaVO pessoaVO = pessoaServicos.findById(id);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).findById(id)).withSelfRel());
		return pessoaVO;
	}
	
	@ApiOperation(value = "Inseri novo registros de Pessoa")
	@PostMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO create(@RequestBody PessoaVO pessoa){
		PessoaVO pessoaVO = pessoaServicos.create(pessoa);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).findById(pessoaVO.getKey())).withSelfRel());
		return pessoaVO;
	}
	
	@ApiOperation(value = "Atualiza o registro da Pessoa")
	@PutMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO update(@RequestBody PessoaVO pessoa){
		PessoaVO pessoaVO = pessoaServicos.update(pessoa);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).findById(pessoaVO.getKey())).withSelfRel());
		return pessoaVO;
	}
	
	@ApiOperation(value = "Exclue o registro da Pessoa")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		 pessoaServicos.delete(id);
		 return ResponseEntity.ok().build();
	}
	
}
