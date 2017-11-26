package com.tiket.tix.controllers;

public class Response<T> {
    private String responseCode;
    private String responseMessage;
    private String lang;
    private T promoLists;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    public T getPromoLists() {
        return this.promoLists;
    }

    public void setPromoLists(T promoLists) {
        this.promoLists = promoLists;
    }
}

