package com.msc.backend.constant;

public enum verificateConstant {

    k_induction("--k-induction",0),
    falsification("--falsification",1),
    incremental_bmc("--incremental-bmc",2);

    private String name;
    private int index;

    verificateConstant(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
