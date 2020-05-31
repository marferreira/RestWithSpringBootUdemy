package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converter.ConversaoNumerico;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.CalculoMatematico;

@RestController
public class MathController {
	
	private CalculoMatematico calculoMatematico = new CalculoMatematico();
	
	@RequestMapping(value="/soma/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!ConversaoNumerico.isNumeric(numberOne)|| !ConversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double soma = calculoMatematico.soma(ConversaoNumerico.convertToDouble(numberOne), ConversaoNumerico.convertToDouble(numberTwo));
		
		return soma;
		
	}
	
	@RequestMapping(value="/multiplicacao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!ConversaoNumerico.isNumeric(numberOne)|| !ConversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double multiplicacao = calculoMatematico.multiplicacao(ConversaoNumerico.convertToDouble(numberOne), ConversaoNumerico.convertToDouble(numberTwo));
		
		return multiplicacao;
		
	}
	
	@RequestMapping(value="/divisao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!ConversaoNumerico.isNumeric(numberOne)|| !ConversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double divisao = calculoMatematico.divisao(ConversaoNumerico.convertToDouble(numberOne), ConversaoNumerico.convertToDouble(numberTwo));
		
		return divisao;
		
	}
	
	@RequestMapping(value="/subtracao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!ConversaoNumerico.isNumeric(numberOne)|| !ConversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double subtracao = calculoMatematico.subtracao(ConversaoNumerico.convertToDouble(numberOne), ConversaoNumerico.convertToDouble(numberTwo));
		
		return subtracao;
		
	}
	
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!ConversaoNumerico.isNumeric(numberOne)|| !ConversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double media = calculoMatematico.media(ConversaoNumerico.convertToDouble(numberOne), ConversaoNumerico.convertToDouble(numberTwo));
		
		return media;
		
	}
	
	@RequestMapping(value="/raizquadrada/{numberOne}", method = RequestMethod.GET)
	public Double raizquadrada(@PathVariable("numberOne") String numberOne) throws Exception{
		if(!ConversaoNumerico.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double raizquadrada = calculoMatematico.raizquadrada(ConversaoNumerico.convertToDouble(numberOne));
		
		return raizquadrada;
	}

	
}
