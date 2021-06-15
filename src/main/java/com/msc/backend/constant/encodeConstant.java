package com.msc.backend.constant;

public enum encodeConstant {
    ir("--ir",0),
    fixedbv("--fixedbv",1),
    floatbv("--floatbv",2);

    private String name;
    private int index;

    encodeConstant(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
