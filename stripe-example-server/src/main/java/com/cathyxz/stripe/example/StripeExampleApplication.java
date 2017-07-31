package com.cathyxz.stripe.example;

import com.cathyxz.stripe.example.health.StripeExampleHealthCheck;
import com.cathyxz.stripe.example.resources.CheckoutResource;
import com.cathyxz.stripe.example.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(final StripeExampleConfiguration configuration,
                    final Environment environment) {

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");


        // TODO: implement application

        environment.healthChecks().register("example", new StripeExampleHealthCheck());
        environment.jersey().register(new HelloWorldResource());
        environment.jersey().register(new CheckoutResource(configuration.getStripeConfiguration()));


    }

}
