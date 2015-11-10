package edu.fatec.sapa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_periodo")
public class Periodo {
	private int cod_periodo;
	private int ano_ingresso;
	private int semestre_ingresso;
	private String periodo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCod_periodo() {
		return cod_periodo;
	}
	public void setCod_periodo(int cod_periodo) {
		this.cod_periodo = cod_periodo;
	}
	
	public int getAno_ingresso() {
		return ano_ingresso;
	}
	public void setAno_ingresso(int ano_ingresso) {
		this.ano_ingresso = ano_ingresso;
	}
	
	public int getSemestre_ingresso() {
		return semestre_ingresso;
	}
	public void setSemestre_ingresso(int semestre_ingresso) {
		this.semestre_ingresso = semestre_ingresso;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
}
