package com.cathyxz.stripe.example.resources;

import com.cathyxz.stripe.example.StripeConfiguration;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/checkout")
@Produces(MediaType.APPLICATION_JSON)
public class CheckoutResource {
    private String stripeApiKey;

    public CheckoutResource(StripeConfiguration stripeConfiguration) {
        this.stripeApiKey = stripeConfiguration.getStripeApiKey();
    }

    @POST
    @Path(("pay"))
    public void submitPayment(String tokenId) {

        // TODO: don't ever commit secret keys to version control
        Stripe.apiKey = this.stripeApiKey;

        try {

            Map<String, Object> params = new HashMap<>();
            params.put("amount", 1000);
            params.put("currency", "usd");
            params.put("description", "Example charge");
            params.put("source", tokenId);
            Charge.create(params);


        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (CardException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }

    }
}
