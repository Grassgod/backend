package com.msc.backend.constant;

public enum solverConstant {
    Z3("--z3",0),
    boolector("--boolector",1),
    yices("--yices",2),
    mathsat("--mathsat",3),
    cvc("--cvc",4);


    private String name;
    private int index;

    private solverConstant(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
