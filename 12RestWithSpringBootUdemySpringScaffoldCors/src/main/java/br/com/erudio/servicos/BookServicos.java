package br.com.erudio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.modelo.Book;
import br.com.erudio.data.vo.BookVO;
import br.com.erudio.exception.ResourcesNotFoundException;
import br.com.erudio.repository.BookRepository;

@Service
public class BookServicos {
	
	@Autowired
	BookRepository bookRepository; 
	
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
		return vo;
	}
	
	public BookVO update(BookVO book) {
		
		var entity = bookRepository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
				
		var vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Book pes = bookRepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado pelo ID"));
		
		bookRepository.delete(pes);
	}
	
	public List<BookVO> findAll() {
		return DozerConverter.parseListObjects(bookRepository.findAll(), BookVO.class);
	}
	
	public BookVO findById(Long id) {
		var entity = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado pelo ID"));
		return DozerConverter.parseObject(entity, BookVO.class);
	}

	
	
}
