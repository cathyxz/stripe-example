import React from 'react';
import {Elements} from 'react-stripe-elements';

import CheckoutForm from './CheckoutForm';

class MyCheckoutForm extends React.Component {
  render() {
    return (
      <Elements>
        <CheckoutForm />
      </Elements>
    );
  }
}

export default MyCheckoutForm;