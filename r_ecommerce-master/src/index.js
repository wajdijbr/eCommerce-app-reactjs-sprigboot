import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../src/assets/css/custom.css';
import { ThemeProvider } from '@material-ui/core/styles';
import { createTheme } from '@mui/material/styles';

const theme = createTheme({
  palette: {
    primary: {
      main:   '#1565c0',
    
      
    },
    secondary: {
      main: '#9575cd',
    },
    error: {
      main: '#e74c3c',
    },
  },
});


ReactDOM.render(
  <React.StrictMode>
        <ThemeProvider theme={theme}>    

  <App className='body-style'/>

</ThemeProvider>


  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
