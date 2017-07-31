package com.cathyxz.stripe.example.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableSaying.class)
@JsonDeserialize(as = ImmutableSaying.class)
public interface Saying {
     @JsonProperty("content") String content();
}
