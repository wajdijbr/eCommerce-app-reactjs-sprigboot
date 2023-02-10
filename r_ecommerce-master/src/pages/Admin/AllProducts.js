import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Typography from '@material-ui/core/Typography';
import axios from 'axios';
import  { useEffect, useState } from 'react';
const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    textAlign: 'center',


  },
  card: {
    maxWidth: 400,
    borderRadius: 8,
    margin:     20 ,
    textAlign: 'center',

    


  },
  media: {
    height: 300,

  },
}));

const AllProducts = () => {

  const classes = useStyles();
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/produits')
      .then(res => {
        setProducts(res.data);
        console.log(res.data);
      })
      .catch(err => console.error(err))
  }, []);

  return (
    <div className={classes.root}>
      <Grid container spacing={3}>
        {products.map((product) => (
          <Grid item xs={12} sm={6} md={4} lg={3} key={product.id}>
   {products.map(product =>  (

            <Card className={classes.card}>
              <CardMedia
                className={classes.media}
                image={product.imagProduit}
                title={product.nomProduit}
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="h2">
                  {product.nomProduit}
                </Typography>
                <Typography variant="body2" color="textSecondary" component="p">
                  {product.descProduit}
                </Typography>
              </CardContent>
            </Card>
                                     ))}

          </Grid>
        ))}
      </Grid>
    </div>
  );
};

export default AllProducts;
