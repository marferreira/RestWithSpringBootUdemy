package br.com.erudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converter.ConversaoNumerico;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.CalculoMatematico;

@RestController
public class MathController {
	
	@Autowired
	private CalculoMatematico calculoMatematico;
	
	@Autowired
	private ConversaoNumerico conversaoNumerico;
	
	@RequestMapping(value="/soma/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!conversaoNumerico.isNumeric(numberOne)|| !conversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double soma = calculoMatematico.soma(conversaoNumerico.convertToDouble(numberOne), conversaoNumerico.convertToDouble(numberTwo));
		
		return soma;
		
	}
	
	@RequestMapping(value="/multiplicacao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!conversaoNumerico.isNumeric(numberOne)|| !conversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double multiplicacao = calculoMatematico.multiplicacao(conversaoNumerico.convertToDouble(numberOne), conversaoNumerico.convertToDouble(numberTwo));
		
		return multiplicacao;
		
	}
	
	@RequestMapping(value="/divisao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!conversaoNumerico.isNumeric(numberOne)|| !conversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double divisao = calculoMatematico.divisao(conversaoNumerico.convertToDouble(numberOne), conversaoNumerico.convertToDouble(numberTwo));
		
		return divisao;
		
	}
	
	@RequestMapping(value="/subtracao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!conversaoNumerico.isNumeric(numberOne)|| !conversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double subtracao = calculoMatematico.subtracao(conversaoNumerico.convertToDouble(numberOne), conversaoNumerico.convertToDouble(numberTwo));
		
		return subtracao;
		
	}
	
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!conversaoNumerico.isNumeric(numberOne)|| !conversaoNumerico.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double media = calculoMatematico.media(conversaoNumerico.convertToDouble(numberOne), conversaoNumerico.convertToDouble(numberTwo));
		
		return media;
		
	}
	
	@RequestMapping(value="/raizquadrada/{numberOne}", method = RequestMethod.GET)
	public Double raizquadrada(@PathVariable("numberOne") String numberOne) throws Exception{
		if(!conversaoNumerico.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double raizquadrada = calculoMatematico.raizquadrada(conversaoNumerico.convertToDouble(numberOne));
		
		return raizquadrada;
	}

	
}
