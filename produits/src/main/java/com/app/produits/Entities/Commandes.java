package com.app.produits.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commandes")
public class Commandes implements Serializable {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idCommande;

  
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "idClient")
  private Clients client;

  @OneToMany(  mappedBy="commandes" )
   private List<Produit> produits;

  private LocalDateTime date;

  private Double totalPrix;
@OneToOne(mappedBy = "commande")
  private Factures facture ;


}
    

