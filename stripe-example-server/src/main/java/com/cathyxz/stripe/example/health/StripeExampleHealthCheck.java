package com.cathyxz.stripe.example.health;
import com.codahale.metrics.health.HealthCheck;

public class StripeExampleHealthCheck extends HealthCheck {

    public StripeExampleHealthCheck() {
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
