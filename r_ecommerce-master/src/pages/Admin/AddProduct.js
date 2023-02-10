import React from 'react'
import axios from 'axios';
import TextField from '@mui/material/TextField';
import { Button } from "@material-ui/core";
import FormControl from '@mui/material/FormControl';
import { useState, useEffect } from 'react';
import MediaQuery from 'react-responsive';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import { List, ListItem, ListItemText } from '@material-ui/core'




const AddProduct = () => {
  const [image, setImage] = useState("");
  const [screenWidth, setScreenWidth] = useState(window.innerWidth);
  const [categories, setCategories] = useState([])
  const [selectedCategory, setSelectedCategory] = useState('')


  useEffect(() => {
    axios.get('http://localhost:8080/category')
      .then(res => {
        setCategories(res.data);
        console.log(res.data);
      })
      .catch(err => console.error(err))
  }, []);


  useEffect(() => {
    const handleResize = () => setScreenWidth(window.innerWidth);
    window.addEventListener('resize', handleResize);
    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []);

  const handleChange = event => {
    setSelectedCategory(event.target.value)
  }

  const handleFileInput = (event) => {
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onloadend = () => {
      setImage(reader.result);

    };

    reader.readAsDataURL(file);
  };


  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(event)
    const category = event.target[2].value;
    const nom = event.target.nom.value;
    const description = event.target.description.value;
    const prix = event.target.prix.value;
    const rate = null
    const codeBar = event.target.codeBar.value;
    const stock = event.target.quantite.value;
    const poids = event.target.poids.value;
    const long = event.target.longueur.value;
    const larg = event.target.largeur.value;
    const haut = null;
    const date = null;
    const img = event.target.file.value;
    const taille = event.target.taille.value;
    const etat = true;

    console.log(category, nom, description, prix, rate, codeBar, poids, long, larg, haut, date, img, taille, stock, etat);
    submitFunction(category, nom, description, prix, rate, codeBar, poids, long, larg, haut, date, img, taille, stock, etat);


  };


  const submitFunction = (category, nom, description, prix, rate, codeBar, poids, long, larg, haut, date, img, taille, stock, etat) => {
    axios.post("http://localhost:8080/produits", {
      idCategory: category,
      nomProduit: nom,

      descProduit: description,

      prixProduit: prix,
      rateProduit: rate,
      codeBarProduit: codeBar,
      poidsProduit: poids,
      longProduit: long,
      largProduit: larg,
      hautProduit: haut,
      dateProduit: date,
      imagProduit: img,
      tailleProduit: taille,
      stockProduit: stock,
      etatProduit: etat
    })
      .then(res => {
        console.log("success")

        // console.log(res.data)
      })
      .catch(err => console.error(err))
  }
  return (

    <>


      <MediaQuery minWidth={768}>
        <form onSubmit={handleSubmit}>
          <div className='form-product'>
            <div className='left-form'>

              <TextField name="nom" required id="nom" label="Nom de produit" /><br />

              <FormControl fullWidth>
                <InputLabel id="category">categorie</InputLabel>
                <Select labelId="category" id="category-select" value={selectedCategory} onChange={handleChange} label="Category"   >
                  {categories.map(category => (

                    <MenuItem key={category.idCategory} value={category.idCategory} >
                      {category.nomCategory}
                    </MenuItem>

                  ))}
                </Select>
              </FormControl>
              <br />
              <TextField name="description" required id="description" label="Description de produit" /><br />
              <TextField name="prix" required id="standard-adornment-amount" label="Prix" type="number" /><br />
              <TextField name="codeBar" required id="codeBar" label="Code à barre" /><br />
              <TextField name="quantite" required id="quantite" label="Quantités" type="number" /><br />
            </div>
            <div className='right-form'>
              <TextField name="poids" id="poids" label="Poids" type="number" />
              <TextField name="longueur" id="longueur" label="longueur" type="number" />
              <TextField name="largeur" id="largeur" label="Largueur" type="number" />
              <TextField name="hauteur" id="hauteur" label="hauteur" type="number" />
              <TextField name="taille" id="taille" label="Taille" type="number" />
              <input type="file" name="file" onChange={handleFileInput} /><br />
            </div>
          </div >
          <Button type='submit' variant="contained" color="primary"  >Ajouter </Button>
        </form >
      </MediaQuery>
      <MediaQuery maxWidth={768}>
        <form onSubmit={handleSubmit}>
          <div className='small-display'>

            <TextField className='testfield' name="nom" required id="nom" label="Nom de produit" /><br />
            <FormControl fullWidth>
              <InputLabel id="category">categorie</InputLabel>
              <Select labelId="category" id="category-select" value={selectedCategory} onChange={handleChange} label="Category"   >
                {categories.map(category => (

                  <MenuItem key={category.idCategory} value={category.idCategory}>
                    {category.nomCategory}
                  </MenuItem>
                ))}
              </Select>
            </FormControl><br />

            <TextField name="description" required id="description" label="Description de produit" /><br />
            <TextField name="prix" required id="standard-adornment-amount" label="Prix" type="number" /><br />
            <TextField name="codeBar" required id="codeBar" label="Code à barre" /><br />
            <TextField name="quantite" required id="quantite" label="Quantités" type="number" /><br />

            <TextField name="poids" id="poids" label="Poids" type="number" /><br />
            <TextField name="longueur" id="longueur" label="longueur" type="number" /><br />
            <TextField name="largeur" id="largeur" label="Largueur" type="number" /><br />
            <TextField name="hauteur" id="hauteur" label="hauteur" type="number" /><br />
            <TextField name="taille" id="taille" label="Taille" type="number" /><br />
            <input type="file" name="file" onChange={handleFileInput} /><br />

          </div >
          <Button type='submit' variant="contained" color="primary"  >Ajouter</Button>
        </form >
      </MediaQuery>

    </>
  )
}

export default AddProduct