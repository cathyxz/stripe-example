package com.cathyxz.stripe.example.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {
    private String content;
    public Saying(String content) {
        this.content = content;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
