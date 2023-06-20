package br.com.procedimentos.model;

import java.util.HashMap;
import java.util.Map;

public enum Sexo {

    MASCULINO(1,"M"),
    FEMININO(2,"F");

    private int 	id;
    private String 	descricao;
    
    private static Map<String, Sexo> relacionamento;
    
	private Sexo() {
	}

	private Sexo(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Sexo getSexoPorDescricao(String descricao) {
	    return relacionamento.get(descricao);
	 }
	
	// Popula o relacionamento dos valores para facilitar o retorno
	static {
		relacionamento = new HashMap<String, Sexo>();
	    for(Sexo s : values()) relacionamento.put(s.getDescricao(), s);	  
	}
}