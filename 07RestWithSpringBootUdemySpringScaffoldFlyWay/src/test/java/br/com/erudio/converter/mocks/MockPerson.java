package br.com.erudio.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.data.modelo.Pessoa;
import br.com.erudio.data.vo.PessoaVO;

public class MockPerson {


    public Pessoa mockEntity() {
    	return mockEntity(0);
    }
    
    public PessoaVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Pessoa> mockEntityList() {
        List<Pessoa> pessoa = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            pessoa.add(mockEntity(i));
        }
        return pessoa;
    }

    public List<PessoaVO> mockVOList() {
        List<PessoaVO> pessoa = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            pessoa.add(mockVO(i));
        }
        return pessoa;
    }
    
    private Pessoa mockEntity(Integer number) {
    	Pessoa pessoa = new Pessoa();
    	pessoa.setEndereco("Addres Test" + number);
        pessoa.setPrimeiroNome("First Name Test" + number);
        pessoa.setSexo(((number % 2)==0) ? "Male" : "Female");
        pessoa.setId(number.longValue());
        pessoa.setSegundoNome("Last Name Test" + number);
        return pessoa;
    }

    private PessoaVO mockVO(Integer number) {
    	PessoaVO pessoa = new PessoaVO();
    	pessoa.setEndereco("Addres Test" + number);
        pessoa.setPrimeiroNome("First Name Test" + number);
        pessoa.setSexo(((number % 2)==0) ? "Male" : "Female");
        pessoa.setId(number.longValue());
        pessoa.setSegundoNome("Last Name Test" + number);
        return pessoa;
    }

}
