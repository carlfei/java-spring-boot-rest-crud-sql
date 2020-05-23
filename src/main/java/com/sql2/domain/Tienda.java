package com.sql2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tienda")
@EntityListeners(AuditingEntityListener.class)
public class Tienda {

	@Id
	@Column(name = "idt")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idt;

	@Column(name = "calle")
	private String calle;

	@Column(name = "numero")
	private String numero;

	@Column(name = "distrito")
	private String distrito;

	@Column(name = "cp")
	private int cp;

	public Tienda(Integer idt, String calle, String numero, String distrito, int cp) {
		super();
		this.idt = idt;
		this.calle = calle;
		this.numero = numero;
		this.distrito = distrito;
		this.cp = cp;
	}

	public Tienda() {
		super();

	}

	public Integer getId() {
		return idt;
	}

	public void setId(Integer idt) {
		this.idt = idt;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

}
