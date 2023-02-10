package com.app.produits.Entities;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categories")

public class Category implements Serializable  {
    




@Id
@GeneratedValue 

private Integer idCategory;

private String nomCategory;

@OneToMany(mappedBy = "category",cascade = CascadeType.ALL) 
private List<Produit> produits ;

}
   

    
  