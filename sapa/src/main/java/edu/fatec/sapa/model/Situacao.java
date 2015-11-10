package edu.fatec.sapa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_situacao")
public class Situacao {
	private int cod_situacao;
	private String situacao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCod_situacao() {
		return cod_situacao;
	}
	public void setCod_situacao(int cod_situacao) {
		this.cod_situacao = cod_situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
