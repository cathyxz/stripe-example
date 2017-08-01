This is a basic exercise in learning maven and dropwizard while trying out Stripe's Java API.

## Setup Instructions

### Editing the `server.yml` config file

Define the environment variable `${STRIPE_API_KEY}` with whichever key you intend to use.
Configure the asset override block to define where your front-end assets are going to be hosted from.

```
assets:
  overrides:
    /: ../build # this points at /build in the parent directory
```

### Commands
`mvn idea:idea` to generate intellij `.ipr` files. 
`mvn clean -e install -q` to generate a jar. 
`java -jar target/stripe-example-server-1.0-SNAPSHOT.jar server` to run the application. 


