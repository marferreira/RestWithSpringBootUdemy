package br.com.erudio.math;

import org.springframework.stereotype.Service;

@Service
public class CalculoMatematico {

	public Double soma(Double numberOne, Double numberTwo) throws Exception{
		
		return (numberOne + numberTwo);
		
	}
	
	public Double subtracao(Double numberOne, Double numberTwo) throws Exception{
		
		return numberOne - numberTwo;
		
	}
	
	public Double multiplicacao(Double numberOne, Double numberTwo) throws Exception{
		
		return numberOne * numberTwo;
		
	}

	public Double divisao(Double numberOne, Double numberTwo) throws Exception{
	
	return numberOne / numberTwo;
	
	}

	public Double media(Double numberOne, Double numberTwo) throws Exception{
	
	return (numberOne + numberTwo)/2;
	
	}

	public Double raizquadrada(Double numberOne) throws Exception{
	
	return (Double) Math.sqrt(numberOne);
	
	}
	
}
