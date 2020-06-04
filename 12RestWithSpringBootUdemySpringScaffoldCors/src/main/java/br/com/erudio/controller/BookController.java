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

import br.com.erudio.data.vo.BookVO;
import br.com.erudio.servicos.BookServicos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Book endpoint", description = "Descrição para book", tags = {"BookEndpoint"})
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookServicos bookServicos;
	
	@ApiOperation(value = "Procura todas os registros de Livros")
	@GetMapping(produces = {"application/json","application/xml", "application/x-yaml"})
	public List<BookVO> findAll(){
		List<BookVO> book =  bookServicos.findAll();
		book
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()
				)
			);
		return book;
	}
	
	@ApiOperation(value = "Procura pelo ID do Livro")
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id){
		BookVO bookVO = bookServicos.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value = "Inseri novo registro de Livro")
	@PostMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json","application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO book){
		BookVO bookVO = bookServicos.create(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value = "Atualiza o registro de Livro")
	@PutMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json","application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO book){
		BookVO bookVO = bookServicos.update(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value = "Exclue o registro de Livro")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		 bookServicos.delete(id);
		 return ResponseEntity.ok().build();
	}
	
}
