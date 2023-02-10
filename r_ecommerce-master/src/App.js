import React, { Component, Fragment } from 'react'

import '../src/assets/css/custom.css'
import { createTheme } from '@mui/material/styles';



import TopNavbar from './components/TopNavbar'

import Footer from './components/common/Footer'
import HomePage from './pages/HomePage'
import ContactPage from './pages/ContactPage'
import FavoratePage from './pages/FavoratePage'
import NotificationPage from './pages/NotificationPage'
import CartListPage from './pages/CartListPage'
import OrderListPage from './pages/OrderListPage'
import RegisterPage from './pages/RegisterPage'
import LoginPage from './pages/LoginPage'
import ForgetPasswordPage from './pages/ForgetPasswordPage'
import ResetPasswordPage from './pages/ResetPasswordPage'
import ProductCategoryPage from './pages/ProductCategoryPage'
import ProductDetailsPage from './pages/ProductDetailsPage'
import SearchPage from './pages/SearchPage'
import AboutPage from './pages/AboutPage'
import AppRouter from './router/AppRouter'
import { ThemeProvider } from '@material-ui/core/styles';

import {  BrowserRouter } from "react-router-dom"





export class App extends Component {
  render() {
    return (
      <Fragment>
        {/* <ChakraProvider> */}
             
      <BrowserRouter>

      <AppRouter/>

      </BrowserRouter>
      {/* </ChakraProvider> */}
      </Fragment>
    )
  }
}

export default App