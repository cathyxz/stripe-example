import React from 'react';
import {CardElement} from 'react-stripe-elements';

class CardSection extends React.Component {

  render() {
    return (
      <label className='pt-label pt-inline'>
        Card details 
        <span className="pt-text-muted"> (required)</span>
        <div className="pt-input stripe-card-element-container">
        <CardElement 
          style={{base: {lineHeight: '30px'}}}
        />
        </div>
      </label>
    );
  }
};

export default CardSection;