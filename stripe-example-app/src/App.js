import React, { Component } from 'react';
import {StripeProvider} from 'react-stripe-elements';
import './App.css';
import MyCheckoutForm from './components/MyCheckoutForm.js'


class App extends Component {
  render() {
    return (
      <div className="App">
        <StripeProvider apiKey="pk_test_zoFVIfYbAVs0N5e91nkSvNEB">
          <MyCheckoutForm/>
        </StripeProvider>
      </div>
    );
  }
}

export default App;
