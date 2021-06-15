package com.msc.backend.controller;

import com.msc.backend.config.GeneralConfig;
import com.msc.backend.entity.ProgramC;
import com.msc.backend.manage.FileManage;
import com.msc.backend.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class FileController {

    @Autowired
    private FileManage fileManage;

    @RequestMapping("/scanFiles")
    public void scanFiles(){
        List<String> fileAddressList = fileManage.scanFile(GeneralConfig.getFileStorageAddress());
        System.out.println(fileAddressList);
        for (int i = 0; i< fileAddressList.size(); i++){
            String address = fileAddressList.get(i);
            if (!fileManage.checkFileExist(FileUtils.addressToName(address), address)){
                System.out.println(FileUtils.addressToName(address)+" "+address);
                fileManage.createFile(FileUtils.addressToName(address), address);
            }
        }
    }

    @RequestMapping("/getAllFiles")
    public void getAllFiles() {
        scanFiles();
        List<ProgramC> list = fileManage.getAllFile();
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getFileName());
        }
    }
}
