import React from 'react';
import {injectStripe} from 'react-stripe-elements';

import CardSection from './CardSection';

class CheckoutForm extends React.Component {
  handleSubmit = (ev) => {
    // We don't want to let default form submission happen here, which would refresh the page.
    ev.preventDefault();

    // Within the context of `Elements`, this call to createToken knows which Element to
    // tokenize, since there's only one in this group.
    this.props.stripe.createToken({name: 'Jenny Rosen'}).then(({token}) => {
      console.log('Received Stripe token:', token);
    });

    // However, this line of code will do the same thing:
    // this.props.stripe.createToken({type: 'card', name: 'Jenny Rosen'});
  }

  render() {
    return (
      <div className="pt-form-group checkout-form-container">
        <form onSubmit={this.handleSubmit}>
          <h1>Checkout Form</h1>
            <label className="pt-label pt-inline">
              Cardholder Name 
              <span className="pt-text-muted"> (required)</span>
              <input className="pt-input" type="text" placeholder="First Name Last Name" dir="auto" />
            </label>
            <CardSection />
            <button className="pt-button" type="submit">Confirm order</button>
          </form>
        </div>
    );
  }
}

export default injectStripe(CheckoutForm);