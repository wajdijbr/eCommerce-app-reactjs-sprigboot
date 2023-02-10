import React, { Fragment, useEffect, useState } from 'react'
import {  Card, Container, Row } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import axios from 'axios';
import  { useRef } from 'react';

import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import '../../assets/css/custom.css';
import Slider from "react-slick";
import { makeStyles } from '@material-ui/core/styles';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Typography from '@material-ui/core/Typography';


const NewArrival = () => {
     const [products, setProducts] = useState([]);

     useEffect(() => {
       axios.get('http://localhost:8080/produits')
         .then(res => {
           setProducts(res.data);
           console.log(res.data);
         })
         .catch(err => console.error(err))
     }, []);

     // const submitFunction = (totalPrix, date) => {
     //      axios.post("http://localhost:8080/commandes", {data: 
     //           {totalPrix: totalPrix, date: date, produits: []}
     //      })
     //       .then(res => {
     //           console.log("success")
     //       })
     //       .catch(err => console.error(err))
     // }
 
     const ref = useRef(null);

     const next = () => {
       ref.current.slickNext();
     };
   
     const previous = () => {
       ref.current.slickPrev();
     };
   

     const settings = {
          dots: false,
          infinite: true,
          speed: 500,
          slidesToShow: 3,
          slidesToScroll: 3 ,
          autoplay: true,
          autoplaySpeed: 1500,
          
     };
  
  
     
     
  return (
                   <>
                    <Container className='slider-conf' fluid={true}>
                         <div className="section-title text-center mb-55"><h2> New Arrival    &nbsp;

                              <a className="btn btn-sm ml-2 site-btn" onClick={previous} ><i className="fa fa-angle-left"></i></a>
                              &nbsp;
                              <a className="btn btn-sm ml-2 site-btn" onClick={next}><i className="fa fa-angle-right"></i></a>

                         </h2>
                              <p>Some Of Our Exclusive Collection, You May Like</p>
                         </div>
                         <Row >
                     
                         <Slider  ref={ref} {...settings}>
                         {products.map(product =>  (
                             
                              
                          <div>
                               <Link to="/productdetails">
                               <Card className="image-box card" >
                                                  <img className="center" src="" />
                                                  <Card.Body>
                                                       <p className="product-name-on-card">{product.nomProduit}</p>
                                                       <div>
                                                            <span className="text-warning">
                                                                 <i className="fa fa-star"></i>
                                                                 <i className="fa fa-star"></i>
                                                                 <i className="fa fa-star"></i>
                                                                 <i className="fa fa-star"> </i>
                                                            </span>
                                                            <span >

                                                                 <i className="fa fa-star"></i>
                                                            </span>
                                                       </div>
                                                       <p className="product-price-on-card">{product.prixProduit   }</p>
                                                  </Card.Body>
                                             </Card>
                                             </Link>
                                             </div>
                       
                       
                         ))}
                         </Slider>
     
                         </Row>
                    </Container>
               </>
  );}
                              

export default NewArrival