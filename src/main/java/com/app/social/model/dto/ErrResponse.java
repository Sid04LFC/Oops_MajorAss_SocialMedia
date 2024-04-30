package com.app.social.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrResponse {
    @JsonProperty("Error")
    private String error;

    public ErrResponse() {
    }

    public ErrResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
