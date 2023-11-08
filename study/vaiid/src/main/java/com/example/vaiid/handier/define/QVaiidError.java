package com.example.vaiid.handier.define;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QVaiidError implements Serializable {

    private String field;
    private String msg;
    private static final String connchar = "=";

    /*
    public static QVaiidError genError() {
        return new QVaiidError();
    }
     */
}
