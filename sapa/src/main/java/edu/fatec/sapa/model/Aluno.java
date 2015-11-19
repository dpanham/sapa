package edu.fatec.sapa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_aluno")
public class Aluno {
	private int cod_aluno;
	private long ra;
	private int sexo;
	private String raca;
	private int cod_situacao;
	private int cod_periodo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCod_aluno() {
		return cod_aluno;
	}
	public void setCod_aluno(int cod_aluno) {
		this.cod_aluno = cod_aluno;
	}
	
	public long getRa() {
		return ra;
	}
	public void setRa(long ra) {
		this.ra = ra;
	}
	
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public int getCod_situacao() {
		return cod_situacao;
	}
	public void setCod_situacao(int cod_situacao) {
		this.cod_situacao = cod_situacao;
	}
	
	public int getCod_periodo() {
		return cod_periodo;
	}
	public void setCod_periodo(int cod_periodo) {
		this.cod_periodo = cod_periodo;
	}	
	
}