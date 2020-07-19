package com.hash.exception.model;

public class ErrorInfoEntity {

    String requestURL;
    String ex;

    public ErrorInfoEntity(String requestURL, String ex) {
        this.requestURL = requestURL;
        this.ex = ex;
    }
}
