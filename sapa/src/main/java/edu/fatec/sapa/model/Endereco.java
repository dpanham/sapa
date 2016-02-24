package edu.fatec.sapa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_endereco")
public class Endereco {
	private int cod_endereco;
	private String endereco;
	private String bairro;
	private String cidade;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCod_endereco() {
		return cod_endereco;
	}
	public void setCod_endereco(int cod_endereco) {
		this.cod_endereco = cod_endereco;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}