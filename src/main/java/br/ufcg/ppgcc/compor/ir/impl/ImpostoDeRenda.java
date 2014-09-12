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
	private Map<Titular, List<Dependente>> dependentes = new HashMap<Titular, List<Dependente>>();

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

	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		inicializarLista(titular);
		if (fonte.getNome() == null) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");

		} else if (fonte.getRendimentoRecebidos() == 0.0) {
			throw new ExcecaoImpostoDeRenda(
					"O campo rendimentos recebidos é obrigatório");

		} else if (fonte.getRendimentoRecebidos() < 0.0) {
			throw new ExcecaoImpostoDeRenda(
					"O campo rendimentos recebidos deve ser maior que zero");
		}
		if (fonte.getCpfCnpj() == null) {
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é obrigatório");
		}

		if (fonte.getCpfCnpj().matches("\\d\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d\\d")) {
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
		}

		if (fonte.getCpfCnpj() == null) {
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é obrigatório");
		} else if (!fonte.getCpfCnpj().matches(
				"[\\d]{2}\\.[\\d]{3}\\.[\\d]{3}\\/[\\d]{4}\\-[\\d]{2}")) {
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é inválido");
		}

		if (titulares.containsKey(titular) == false) {
			throw new ExcecaoImpostoDeRenda("O campo Titular é obrigatório");
		}

		fontesPagadoras.get(titular).add(fonte);
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

	// //////////////////////////////////////////////
	public void criarDependente(Titular titular, Dependente dependente) {

		if (dependente.getNome() == null) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}

		if (dependente.getCpf() == null) {
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
		}

		if (dependente.getTipo() == 0) {
			throw new ExcecaoImpostoDeRenda("O campo tipo é obrigatório");
		}

		if (dependente.getCpf().matches("\\d\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d\\d") == false) {
			throw new ExcecaoImpostoDeRenda("O campo CPF é inválido");
		}

	}

	public List<Dependente> listarDependentes(Titular titular) {
		return dependentes.get(titular);
	}

	public Resultado declaracaoCompleta(Titular titular) {
		return null;
	}

}