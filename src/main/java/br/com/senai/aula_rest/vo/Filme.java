package br.com.senai.aula_rest.vo;

public class Filme {
	
	private Integer filme_id;
	private String titulo;
	private String descricao;
	private String anoLancamento;
	
	public Filme() {
		// TODO Auto-generated constructor stub
	}
	
	public Filme(Integer filme_id, String titulo, String descricao, String anoLancamento) {
		super();
		this.filme_id = filme_id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.anoLancamento = anoLancamento;
	}
	
	public Integer getFilme_id() {
		return filme_id;
	}
	public void setFilme_id(Integer filme_id) {
		this.filme_id = filme_id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	
	
}
