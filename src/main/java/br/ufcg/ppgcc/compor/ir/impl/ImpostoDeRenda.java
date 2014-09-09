package br.ufcg.ppgcc.compor.ir.impl;

import java.util.*;

import br.ufcg.ppgcc.compor.ir.*;

public class ImpostoDeRenda implements FachadaExperimento {

	private List<Titular> titulares = new ArrayList<Titular>();
	private List<FontePagadora> fontePagadores = new ArrayList<FontePagadora>();

	public void criarNovoTitular(Titular titular) {
		
		if ((titular.getNome() == null) || (titular.getNome().equals(""))) {
					throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
				}
		if (titular.getCpf() == null) {
				throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
			}
	
		if (titular.getCpf() != "000.000.000-00") {
				throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
			}
		

		titulares.add(titular);
	}

	public List<Titular> listarTitulares() {

		return titulares;
	}

	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		fontePagadores.add(fonte);
	}

	public List<FontePagadora> listarFontes(Titular titular) {

		return fontePagadores;
	}
/*}
	public void criarDependente(Titular titular, Dependente dependente) {
		// TODO Auto-generated method stub

	}

	public List<Dependente> listarDependentes(Titular titular) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resultado declaracaoCompleta(Titular titular) {
		// TODO Auto-generated method stub
		return null;
	}*/

	


	public void criarDependente(Titular titular, Dependente dependente) {
		// TODO Auto-generated method stub
		
	}

	public List<Dependente> listarDependentes(Titular titular) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resultado declaracaoCompleta(Titular titular) {
		// TODO Auto-generated method stub
		return null;
	}
}