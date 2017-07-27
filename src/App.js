import React, { Component } from 'react';
import {StripeProvider} from 'react-stripe-elements';
import './App.css';
import MyCheckoutForm from './components/MyCheckoutForm.js'


class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <h2>Stripe Example</h2>
        </div>
        <StripeProvider apiKey="placeholder">
          <MyCheckoutForm/>
        </StripeProvider>
      </div>
    );
  }
}

export default App;
