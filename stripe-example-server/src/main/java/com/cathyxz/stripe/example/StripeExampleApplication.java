package com.cathyxz.stripe.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class StripeExampleApplication extends Application<StripeExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new StripeExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "StripeExample";
    }

    @Override
    public void initialize(final Bootstrap<StripeExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final StripeExampleConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
