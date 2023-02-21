package com.example.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clienti database table.
 * 
 */
@Entity
@Table(name="clienti")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLIENTE", insertable=false, updatable=false)
	private Integer idCliente;

	private String cap;

	private String citta;

	private String cognome;

	private String email;

	private String indirizzo;

	private String nome;

	private String provincia;

	public Cliente() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public static Cliente createCliente(String nome, String cognome, String email, String indirizzo, String citta, String cap, String provincia) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCognome(cognome);
		cliente.setEmail(email);
		cliente.setIndirizzo(indirizzo);
		cliente.setCitta(citta);
		cliente.setProvincia(provincia);
		cliente.setCap(cap);
		return cliente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [idCliente=");
		builder.append(idCliente);
		builder.append(", cap=");
		builder.append(cap);
		builder.append(", citta=");
		builder.append(citta);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", indirizzo=");
		builder.append(indirizzo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", provincia=");
		builder.append(provincia);
		builder.append("]");
		return builder.toString();
	}

}