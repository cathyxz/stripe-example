import React, { Component } from 'react';
import { StripeProvider } from 'react-stripe-elements';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import MyCheckoutForm from './components/MyCheckoutForm.js'
import Homepage from './components/Homepage.js';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Switch>
          <Route exact path="/" component={Homepage} />
          <Route>
            <StripeProvider apiKey="pk_test_zoFVIfYbAVs0N5e91nkSvNEB">
              <MyCheckoutForm/>
            </StripeProvider>
          </Route>
        </Switch>
      </div>
    );
  }
}

export default App;
