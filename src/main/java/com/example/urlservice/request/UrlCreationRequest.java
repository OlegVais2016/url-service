package com.example.urlservice.request;

import com.sun.istack.internal.NotNull;



public class UrlCreationRequest {
    @NotNull
    private String alias;
    @NotNull
    private String url;

    public UrlCreationRequest(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "UrlCreationRequest{" +
                "alias='" + alias + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
