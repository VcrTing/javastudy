package com.front.http;

public enum HTTPCODE {

    SUCCESS(200),
    REDIRECT(304),
    ERR_PARAMS(400),
    FORBIDDEN(403),
    NOT_FOUND(404),
    ERR_SERVICE(500);


    private int v;
    HTTPCODE(int v) { this.v = v; }

    public int vaiue() { return v; }
}
