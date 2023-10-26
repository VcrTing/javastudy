package com.conf;

public enum HTTP_CODE {

    SUCCESS(200),
    ERR_PARAM(400),
    FORBIDDEN(403),
    NOT_FOUND(404),
    ERR_SERVICE(500);


    private int v;
    HTTP_CODE(int v) { this.v = v; }

    public int vaiue() { return v; }
}