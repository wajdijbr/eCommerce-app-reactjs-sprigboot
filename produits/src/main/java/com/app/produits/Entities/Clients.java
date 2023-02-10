package com.app.produits.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients implements Serializable {
	
	
	
	@Id()
	@GeneratedValue
	private Integer idClient;
	private String nomClient;
	private String prenomClient;	
	private String adresseClient;
	private Integer zipClient;
	private String emailClient;
	private String passwordClient;
	private Integer telClient;
	private Integer tel1Client;
	private Date dateCClient;
	private String roleClient;
	private Boolean accessClient;
	@OneToMany(  mappedBy="client" )
    private List<Commandes> commandes = new ArrayList<>();


	

}
