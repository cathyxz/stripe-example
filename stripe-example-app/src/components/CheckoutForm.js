import React from 'react';
import {injectStripe} from 'react-stripe-elements';

import CardSection from './CardSection';

class CheckoutForm extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      name: '',
      address_line1: '',
      address_line2: '',
      address_state: '',
      address_city: ''
    };

    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleInputChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  handleSubmit = (ev) => {
    ev.preventDefault();

    var extraDetails = this.state;
    this.props.stripe.createToken(extraDetails).then(({token}) => {
      if (token === undefined) {
        console.log("Token Undefined");
        // TODO: handle errors here
      } else {
        console.log(token);
        fetch("http://localhost:5000/api/checkout/pay", {
          method: "POST",
          body: token.id,
          headers: {
            "Content-Type": "application/json"
          },
          credentials: "same-origin"
        }).then(function(response) {
          console.log(response);
          return response.text()
        }, function(error) {
          console.log(error.message) ;
        })

      }
    });

  }

  render() {
    return (
      <div className="pt-form-group checkout-form-container">
        <form onSubmit={this.handleSubmit}>
          <h1>Checkout Form</h1>
            <label className="pt-label">
              Cardholder Name 
              <span className="pt-text-muted"> (required)</span>
              <input 
                className="pt-input" 
                type="text" 
                name="name" 
                placeholder="Jenny Rosen" 
                dir="auto" 
                value={this.state.name}
                onChange={this.handleInputChange}
                />
            </label>
            <label className="pt-label">
              Address
              <input 
                className="pt-input" 
                type="text" 
                name="address_line1" 
                placeholder="1 Baker St" 
                dir="auto" 
                value={this.state.address_line1}
                onChange={this.handleInputChange}
                />
              <input 
                className="pt-input" 
                type="text" 
                name="address_line2" 
                placeholder="Apt 205" 
                dir="auto" 
                value={this.state.address_line2}
                onChange={this.handleInputChange}
                />
              </label>
            <label className="pt-label pt-inline">
              City
              <input 
                className="pt-input" 
                type="text" 
                name="address_city" 
                placeholder="New York" 
                dir="auto" 
                value={this.state.address_city}
                onChange={this.handleInputChange}
                />
                State
                <input 
                className="pt-input" 
                type="text" 
                name="address_state" 
                placeholder="NY" 
                dir="auto" 
                value={this.state.address_state}
                onChange={this.handleInputChange}
                />
              </label>
            <CardSection />
            <button className="pt-button" type="submit">Confirm order</button>
          </form>
        </div>
    );
  }
}

export default injectStripe(CheckoutForm);