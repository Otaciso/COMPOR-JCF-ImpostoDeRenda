package br.ufcg.ppgcc.compor.ir.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.ir.Dependente;
import br.ufcg.ppgcc.compor.ir.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.ir.FachadaExperimento;
import br.ufcg.ppgcc.compor.ir.FontePagadora;
import br.ufcg.ppgcc.compor.ir.Resultado;
import br.ufcg.ppgcc.compor.ir.Titular;

public class ImpostoDeRenda implements FachadaExperimento {

	private Map<Titular, List<FontePagadora>> titulares = new LinkedHashMap<Titular, List<FontePagadora>>();
	private Map<Titular, List<FontePagadora>> fontePagadoras = new HashMap<Titular, List<FontePagadora>>();
	private Map<Titular, List<FontePagadora>> fontesPagadoras = new HashMap<Titular, List<FontePagadora>>();

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
		titulares.put(titular, new ArrayList<FontePagadora>());
	}

	public List<Titular> listarTitulares() {
		return new ArrayList<Titular>(titulares.keySet());
	}// RRRR\\

	public void criarFontePagadora(Titular titular, FontePagadora fontePagadora) {
		inicializarLista(titular);
		if (fontePagadora.getNome() == null) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
			
		}else if (fontePagadora.getRendimentoRecebidos() == 0.0) {
			throw new ExcecaoImpostoDeRenda(
					"O campo rendimentos recebidos é obrigatório");
			
		} else if (fontePagadora.getRendimentoRecebidos() < 0.0) {
			throw new ExcecaoImpostoDeRenda(
					"O campo rendimentos recebidos deve ser maior que zero");
		}
		if (fontePagadora.getCpfCnpj() == null) {
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é obrigatório");
		}
		
		if (fontePagadora.getCpfCnpj().matches(
				"\\d\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d\\d")) {
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
		}
		fontesPagadoras.get(titular).add(fontePagadora);
		
	}
	
	public List<FontePagadora> listarFontes(Titular titular) {
		inicializarLista(titular);
		return fontesPagadoras.get(titular);
	}
	
	private void inicializarLista(Titular titular) {
		if (fontesPagadoras.get(titular) == null) {
			fontesPagadoras.put(titular, new ArrayList<FontePagadora>());
		}
	}

	
	/*
	 * } public void criarDependente(Titular titular, Dependente dependente) {
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * public List<Dependente> listarDependentes(Titular titular) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * public Resultado declaracaoCompleta(Titular titular) { // TODO
	 * Auto-generated method stub return null; }
	 */

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


	
	/*public List<FontePagadora> listarFontes(Titular titular) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
}