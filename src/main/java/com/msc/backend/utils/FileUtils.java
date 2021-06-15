package com.msc.backend.utils;

public class FileUtils {

    public static String addressToName(String fileAddress){
        return fileAddress.substring(fileAddress.lastIndexOf('/')+1, fileAddress.length());
    }
}