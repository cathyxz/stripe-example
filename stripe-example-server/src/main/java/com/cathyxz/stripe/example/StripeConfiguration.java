package com.cathyxz.stripe.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StripeConfiguration {

    @JsonProperty
    private String stripeApiKey;

    public String getStripeApiKey() {
        return stripeApiKey;
    }
}
