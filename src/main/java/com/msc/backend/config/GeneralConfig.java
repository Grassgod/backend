package com.msc.backend.config;

public final class GeneralConfig {

    private final static String fileStorageAddress = "/home/jkclee_hk/deploydir/sourcefiles/";

//    private final static String fileStorageAddress = "/Users/grassgod/Documents/Manchester/MSCProject/2021/Code/data/unreachcall/";

    private GeneralConfig(){

    }

    public static String getFileStorageAddress() {
        return fileStorageAddress;
    }
}
