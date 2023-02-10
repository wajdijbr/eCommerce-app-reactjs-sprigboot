package com.app.produits.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "factures")
public class Factures implements Serializable {

  @Id
  @JoinColumn(name="idCommande")

  private Long idFactures;
@OneToOne
@JoinColumn(name="idCommande")
  private Commandes commande;

  
}