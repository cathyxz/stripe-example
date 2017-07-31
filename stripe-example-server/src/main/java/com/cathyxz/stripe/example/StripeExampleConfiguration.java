package com.cathyxz.stripe.example;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.bundles.assets.AssetsBundleConfiguration;
import io.dropwizard.bundles.assets.AssetsConfiguration;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class StripeExampleConfiguration extends Configuration implements AssetsBundleConfiguration {
    @JsonProperty
    private final AssetsConfiguration assets = AssetsConfiguration.builder().build();

    @JsonProperty("stripe")
    private StripeConfiguration stripeConfiguration;

    @Override
    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }

    public StripeConfiguration getStripeConfiguration() {
        return stripeConfiguration;
    }

}
