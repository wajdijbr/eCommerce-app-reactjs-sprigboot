package com.app.produits.Entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produits")
public class Produit implements Serializable {

@Id
@GeneratedValue 
private Integer idProduit;
@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "idCategory")
   

private Category category ;
private String nomProduit;
private String descProduit;
private Double prixProduit;
private Double rateProduit;
private Integer codeBarProduit;
private Double poidsProduit;
private Double longProduit;
private Double largProduit;
private Double hautProduit;
private Date dateCProduit;

private String imagProduit;

private String tailleProduit;
private Integer stockProduit;
 private Boolean etatProduit;

 private Commandes commandes;




@Override
public String toString() {
    return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", descProduit=" + descProduit
            + ", prixProduit=" + prixProduit + ", rateProduit=" + rateProduit + ", dateCProduit=" + dateCProduit
            + ", codeBarProduit=" + codeBarProduit + ", poidsProduit=" + poidsProduit + ", imagProduit=" + imagProduit
            + ", longProduit=" + longProduit + ", largProduit=" + largProduit + ", hautProduit=" + hautProduit
            + ", tailleProduit=" + tailleProduit + ", stockProduit=" + stockProduit ;
}

















}

